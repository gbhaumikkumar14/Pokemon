package com.bhaumikghodasara.pokemon.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.bhaumikghodasara.data.models.PokemonMasterData
import com.bhaumikghodasara.pokemon.R
import com.bhaumikghodasara.pokemon.adapters.PokemonListAdapter
import com.bhaumikghodasara.pokemon.databinding.FragmentPokemonHomeBinding
import com.bhaumikghodasara.pokemon.util.isLetters
import com.bhaumikghodasara.pokemon.viewmodels.PokemonViewModel


class PokemonHomeFragment : Fragment(), PokemonListAdapter.OnItemClick {
    private lateinit var binding : FragmentPokemonHomeBinding
    private lateinit var pokemonViewModel: PokemonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPokemonHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemonViewModel = ViewModelProvider(requireActivity())[PokemonViewModel::class.java]
        pokemonViewModel.getPokemonList()
        setUpRecyclerView()
        setUpSearchAndFilter()
    }

    private fun setUpRecyclerView() {
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        pokemonViewModel.masterDetailsLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                val adapter = PokemonListAdapter(it, this)
                binding.recyclerView.adapter = adapter
            }
            binding.loaderView.visibility = View.GONE
        }
    }

    private fun setUpSearchAndFilter() {
        binding.textInputEditPokemonSearch.setOnEditorActionListener { view, actionId, _ ->
            when (actionId and EditorInfo.IME_MASK_ACTION) {
                EditorInfo.IME_ACTION_DONE -> {
                    if (view == null || (view.text?.isEmpty() ?: "") as Boolean) {
                        pokemonViewModel.resetData()
                    }
                    searchInList(view?.text)
                }
            }
            true
        }

        binding.btnFilter.setOnClickListener {
            pokemonViewModel.fetchFilterData()
        }

        pokemonViewModel.isFilterDataReceived.observe(viewLifecycleOwner) {
            if (it) {
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.add(R.id.home_fragment_root, FilterFragment())
                transaction.addToBackStack("FilterFragment")
                transaction.commit()
            }
        }
    }

    private fun searchInList(text: CharSequence?) {
        if (text.toString().isEmpty()) {
            return
        }
        if (text!!.isNotEmpty() && text.toString().isLetters()) {
            val dataKey = pokemonViewModel.masterDetailsLiveData.value
            val filteredData = HashMap<String, PokemonMasterData>()
            if (dataKey != null) {
                dataKey.forEach { (key, value) ->
                    if (key.contains(text, true)) {
                        filteredData[key] = value
                    }
                }
                pokemonViewModel.masterDetailsLiveData.value = filteredData
            }
        } else {
            val filteredData = HashMap<String, PokemonMasterData>()
            pokemonViewModel.masterDetailsLiveData.value?.forEach { (key, value) ->
                if (text.contains(value.pokemonDetailData?.id.toString(), true)) {
                    filteredData[key] = value
                }
            }
            pokemonViewModel.masterDetailsLiveData.value = filteredData
        }
    }

    override fun onItemClicked(position: Int, pokemonName: String) {
        pokemonViewModel.setSelectedPokemonName(pokemonName)

        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.add(R.id.home_fragment_root, PokemonDetailFragment())
        transaction.addToBackStack("PokemonDetailFragment")
        transaction.commit()
    }

    companion object {
        private const val TAG = "PokemonHomeFragment"
    }
}