package com.bhaumikghodasara.pokemon.fragments

import android.annotation.SuppressLint
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import com.bhaumikghodasara.domain.entities.*
import com.bhaumikghodasara.pokemon.R
import com.bhaumikghodasara.pokemon.databinding.FragmentPokemonDetailBinding
import com.bhaumikghodasara.pokemon.util.Constants
import com.bhaumikghodasara.pokemon.util.Utils
import com.bhaumikghodasara.pokemon.util.capitalizeFirstCharacter
import com.bhaumikghodasara.pokemon.util.loadImage
import com.bhaumikghodasara.pokemon.viewmodels.PokemonViewModel

class PokemonDetailFragment : Fragment() {
    private lateinit var binding: FragmentPokemonDetailBinding
    private lateinit var pokemonViewModel: PokemonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPokemonDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemonViewModel = ViewModelProvider(requireActivity())[PokemonViewModel::class.java]
        setUpUi()
    }

    private fun setUpUi() {
        pokemonViewModel.getPokemonDetail(pokemonViewModel.selectedPokemonId.value)

        binding.readMore.setOnClickListener {
            showPopUpWindow()
        }
        binding.closeButton.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
        pokemonViewModel.pokemonDetailLiveData.observe(viewLifecycleOwner) {
            handleSuccessResponse(it)
        }
        pokemonViewModel.pokemonAdditionalDetailLiveData.observe(viewLifecycleOwner) { it ->
            if (it != null) {
                binding.pokemonDescription.text = it.flavorTextEntries
                binding.eggGroupsValue.text = it.eggGroups.joinToString()
            }
        }
        pokemonViewModel.pokemonStrengthAndWeaknessLiveData.observe(viewLifecycleOwner) {
            handleWeakness(it)
        }
        pokemonViewModel.pokemonEvolutionChainLiveData.observe(viewLifecycleOwner) {
            showEvolutionChain(it)
        }
        setCTAData()
    }

    private fun setCTAData() {
        val listPokedex: List<String> =
            pokemonViewModel.masterDetailsLiveData.value?.keys?.toList() ?: listOf()
        if (listPokedex.isNotEmpty()) {
            val index = listPokedex.indexOf(pokemonViewModel.selectedPokemonId.value)
            if (index > 1) {
                binding.previous.text = listPokedex[index - 1].capitalizeFirstCharacter()
                binding.previous.visibility = View.VISIBLE
            } else {
                binding.previous.visibility = View.INVISIBLE
            }

            if (index < listPokedex.size - 1) {
                binding.next.text = listPokedex[index + 1].capitalizeFirstCharacter()
                binding.next.visibility = View.VISIBLE
            } else {
                binding.next.visibility = View.INVISIBLE
            }

            binding.previous.setOnClickListener {
                pokemonViewModel.selectedPokemonMutableLiveData.value = listPokedex[index - 1]
                setUpUi()

            }
            binding.next.setOnClickListener {
                pokemonViewModel.selectedPokemonMutableLiveData.value = listPokedex[index + 1]
                setUpUi()
            }
        }
    }

    private fun showEvolutionChain(evolutionChainData: EvolutionChainData?) {
        binding.evolutionImage.removeAllViews()
        if (evolutionChainData != null) {
            for (i in 0 until  evolutionChainData.species.size) {
                val species = evolutionChainData.species[i]
                val types = getTypesData(species?.name)
                val typesList = types?.map { it -> it.type?.name }
                val layout =
                    LayoutInflater.from(requireContext()).inflate(R.layout.evolution_chain_view, null)
                val background = layout.findViewById<ConstraintLayout>(R.id.item_view)
                val pokedexImage = layout.findViewById<ImageView>(R.id.evolution_chain_pokemon_image)
                val nextArrow = layout.findViewById<ImageView>(R.id.next_arrow)
                if(i < (evolutionChainData.species.size - 1)) {
                    nextArrow.visibility = View.VISIBLE
                }

                val imageId = species?.url?.replace("https://pokeapi.co/api/v2/pokemon-species/", "")
                    ?.replace("/", "")
                pokedexImage.loadImage("${Constants.BASE_IMAGE_URL}${imageId}${Constants.IMG_EXTENSION}")
                if (typesList != null) {
                    background.background =
                        Utils().getGradientColors(requireContext(), typesList.toMutableList())
                }
                binding.evolutionImage.addView(layout)
            }
        }

    }

    private fun getTypesData(name: String?): List<Types>? {
        return pokemonViewModel.masterDetailsLiveData.value?.get(name)?.pokemonDetailData?.types
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun showPopUpWindow() {
        val popupView: View =
            LayoutInflater.from(requireContext()).inflate(R.layout.popup_view, null)

        val width = LinearLayout.LayoutParams.WRAP_CONTENT
        val height = LinearLayout.LayoutParams.WRAP_CONTENT
        val focusable = true // lets taps outside the popup also dismiss it
        val popupWindow = PopupWindow(popupView, width, height, focusable)
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)
        popupView.setOnTouchListener { _, _ ->
            popupWindow.dismiss()
            true
        }
        popupView.findViewById<TextView>(R.id.description).text =
            pokemonViewModel.pokemonAdditionalDetailLiveData.value?.flavorTextEntries
        popupView.findViewById<ImageButton>(R.id.close_button).setOnClickListener {
            popupWindow.dismiss()
        }
    }

    private fun handleWeakness(strengthWeaknessData: StrengthWeaknessData?) {
        binding.weakAgainstGroup.removeAllViews()
        if (strengthWeaknessData?.damageRelations != null) {
            for (data in strengthWeaknessData.damageRelations?.doubleDamageFrom!!) {
                val linearView: LinearLayout =
                    LayoutInflater.from(requireContext())
                        .inflate(R.layout.custom_text_view, null) as LinearLayout
                val typeView = linearView.findViewById<TextView>(R.id.child)
                typeView.text = data?.capitalizeFirstCharacter()
                typeView.setBackgroundResource(R.drawable.round_corners)
                val drawable: GradientDrawable = typeView.background as GradientDrawable
                data?.let { drawable.setColor(Utils.getTypesColor(it, requireContext())) }
                binding.weakAgainstGroup.addView(linearView)
            }
        }
    }

    private fun handleSuccessResponse(it: PokemonDetailData?) {
        binding.pokemonDetailId.text = String.format(Constants.IMG_ID_FORMAT, it?.id)
        binding.pokemonDetailName.text = it?.name
        binding.heightValue.text = it?.height.toString()
        binding.weightValue.text = it?.weight.toString()
        binding.abilitiesValue.text = it?.abilities?.map { result -> result.ability?.name }
            ?.toMutableList()
            ?.joinToString()
        it?.sprites?.frontDefault?.let { it1 ->
            binding.pokemonDetailImage.loadImage(
                it1,
                R.drawable.ic_pokemon
            )
        }
        addTypesViews(it?.types?.map { result -> result.type?.name }
            ?.toMutableList())

        addStatics(it?.stats)


    }

    private fun addStatics(statsList: List<Stats>?) {
        binding.statsViewGroup.removeAllViews()
        if (statsList != null) {
            for (stats in statsList) {
                val linearView: ConstraintLayout =
                    LayoutInflater.from(requireContext())
                        .inflate(R.layout.stats_view, null) as ConstraintLayout
                val typeView = linearView.findViewById<TextView>(R.id.statType)
                val statsValue = linearView.findViewById<TextView>(R.id.statValue)
                val statsProgressBar = linearView.findViewById<ProgressBar>(R.id.statsProgressBar)

                typeView.text = stats.stat?.name
                statsValue.text = stats.baseStat.toString()
                stats.baseStat?.let { statsProgressBar.progress = it }
                binding.statsViewGroup.addView(linearView)
            }
        }
    }

    private fun addTypesViews(types: MutableList<String?>?) {
        binding.typesViewGroup.removeAllViews()
        if (types != null) {
            for (type in types) {
                val linearView: LinearLayout =
                    LayoutInflater.from(requireContext())
                        .inflate(R.layout.custom_text_view, null) as LinearLayout

                val typeView = linearView.findViewById<TextView>(R.id.child)
                typeView.text = type?.capitalizeFirstCharacter()
                typeView.setBackgroundResource(R.drawable.round_corners)
                val drawable: GradientDrawable = typeView.background as GradientDrawable
                type?.let { drawable.setColor(Utils.getTypesColor(it, requireContext())) }
                binding.typesViewGroup.addView(linearView)
            }
            setImageBackground(types)
        }
    }

    private fun setImageBackground(types: MutableList<String?>) {
        binding.imageBackground.background = Utils().getGradientColors(requireContext(), types)
    }

    companion object {
        private const val TAG = "PokemonDetailFragment"
    }
}