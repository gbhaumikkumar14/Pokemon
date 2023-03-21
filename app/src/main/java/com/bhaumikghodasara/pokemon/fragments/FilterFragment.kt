package com.bhaumikghodasara.pokemon.fragments

import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.bhaumikghodasara.pokemon.R
import com.bhaumikghodasara.pokemon.adapters.PokemonTypeFilterAdapter
import com.bhaumikghodasara.pokemon.adapters.PokemonGenderFilterAdapter
import com.bhaumikghodasara.pokemon.databinding.FragmentFilterBinding
import com.bhaumikghodasara.pokemon.util.GridSpacingItemDecoration
import com.bhaumikghodasara.pokemon.viewmodels.PokemonViewModel

class FilterFragment : Fragment(), PokemonTypeFilterAdapter.TypeItemClickListener,
    PokemonGenderFilterAdapter.GenderItemClickListener {
    private lateinit var binding : FragmentFilterBinding
    private lateinit var pokemonViewModel : PokemonViewModel
    private var genderSelect = HashSet<String>()
    private var typeSelect = HashSet<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFilterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pokemonViewModel = ViewModelProvider(requireActivity())[PokemonViewModel::class.java]
        setUpUI()
    }

    private fun setUpUI() {
        if(pokemonViewModel.selectedGenderFilterLiveData.value != null){
            genderSelect = pokemonViewModel.selectedGenderFilterLiveData.value!!
            displaySelectedFilters()
        }
        if(pokemonViewModel.selectedTypeFilterLiveData.value != null) {
            typeSelect = pokemonViewModel.selectedTypeFilterLiveData.value!!
            displaySelectedFilters()
        }

        handleTypesFilterUI()

        handleGenderFilterUI()

        binding.closeButton.setOnClickListener { requireActivity().onBackPressedDispatcher.onBackPressed() }
        binding.applyButton.setOnClickListener {
            pokemonViewModel.selectedGenderFilterLiveData.value = genderSelect
            pokemonViewModel.selectedTypeFilterLiveData.value = typeSelect
            displaySelectedFilters()

            pokemonViewModel.applyFilters()
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
        binding.resetButton.setOnClickListener {
            genderSelect.clear()
            typeSelect.clear()
            pokemonViewModel.selectedGenderFilterLiveData.value = genderSelect
            pokemonViewModel.selectedTypeFilterLiveData.value = typeSelect

            binding.genderFilter.selectedFilter.text = ""
            binding.typesFilter.selectedFilter.text = ""
            pokemonViewModel.resetData()
        }
    }

    private fun displaySelectedFilters() {
        if (genderSelect.isNotEmpty()) {
            val spannableGender =
                SpannableString("${genderSelect.last()} + ${genderSelect.size - 1} more")
            spannableGender.setSpan(
                StyleSpan(Typeface.BOLD),
                genderSelect.last().length + 2, spannableGender.length - 2,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            binding.genderFilter.selectedFilter.text = spannableGender
        }
        if (typeSelect.isNotEmpty()) {
            println("${typeSelect.last().length}")
            val spannableType =
                SpannableString("(${typeSelect.last()} + ${typeSelect.size - 1} more)")
            spannableType.setSpan(
                StyleSpan(Typeface.BOLD),
                typeSelect.last().length + 2, spannableType.length - 2,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            binding.typesFilter.selectedFilter.text = spannableType
        }
    }

    /**
     * This method will handle UI for gender filter
     */
    private fun handleGenderFilterUI() {
        binding.genderFilter.filterHeader.text = requireContext().getString(R.string.gender)
        binding.genderFilter.expandCollapse.setOnClickListener {
            if (binding.genderFilter.hiddenView.visibility == View.GONE) {
                binding.genderFilter.hiddenView.visibility = View.VISIBLE
                binding.genderFilter.expandCollapse.setImageResource(R.drawable.ic_collapse)
            } else {
                binding.genderFilter.hiddenView.visibility = View.GONE
                binding.genderFilter.expandCollapse.setImageResource(R.drawable.ic_expand)
            }
        }

        pokemonViewModel.genderFilterLiveData.observe(viewLifecycleOwner) {
            binding.genderFilter.filtersRecyclerview.layoutManager =
                GridLayoutManager(requireContext(), 2)
            binding.genderFilter.filtersRecyclerview.addItemDecoration(
                GridSpacingItemDecoration(
                    2,
                    40,
                    true
                )
            )
            val adapter =
                it?.let { it1 -> PokemonGenderFilterAdapter(it1.genderResult, this, genderSelect) }
            binding.genderFilter.filtersRecyclerview.adapter = adapter
        }
    }

    /**
     * This method will handle UI for type filter
     */
    private fun handleTypesFilterUI() {
        pokemonViewModel.typeFilterLiveData.observe(viewLifecycleOwner) {
            binding.typesFilter.filtersRecyclerview.layoutManager =
                GridLayoutManager(requireContext(), 2)
            binding.typesFilter.filtersRecyclerview.addItemDecoration(
                GridSpacingItemDecoration(
                    2,
                    40,
                    true
                )
            )
            val adapter = it?.let { it1 -> PokemonTypeFilterAdapter(it1.typeFilters, this, typeSelect) }
            binding.typesFilter.filtersRecyclerview.adapter = adapter
        }
        binding.typesFilter.filterHeader.text = requireContext().getString(R.string.type)

        binding.typesFilter.expandCollapse.setOnClickListener {
            if (binding.typesFilter.hiddenView.visibility == View.GONE) {
                binding.typesFilter.hiddenView.visibility = View.VISIBLE
                binding.typesFilter.expandCollapse.setImageResource(R.drawable.ic_collapse)
            } else {
                binding.typesFilter.hiddenView.visibility = View.GONE
                binding.typesFilter.expandCollapse.setImageResource(R.drawable.ic_expand)
            }
        }
    }

    override fun onTypeItemClicked(position: Int, filterName: String, isChecked: Boolean) {
        if (isChecked) {
            typeSelect.add(filterName)
        } else {
            typeSelect.remove(filterName)
        }

    }

    override fun onGenderItemClicked(position: Int, genderName: String, isChecked: Boolean) {
        if (isChecked) {
            genderSelect.add(genderName)
        } else {
            genderSelect.remove(genderName)
        }
    }

    companion object {
        private const val TAG = "FilterFragment"
    }
}