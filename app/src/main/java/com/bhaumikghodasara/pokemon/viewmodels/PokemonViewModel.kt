package com.bhaumikghodasara.pokemon.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bhaumikghodasara.data.models.PokemonMasterData
import com.bhaumikghodasara.domain.entities.*
import com.bhaumikghodasara.domain.entities.common.ApiResult
import com.bhaumikghodasara.domain.usecases.PokemonUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(private val pokemonUseCases: PokemonUseCases): ViewModel() {
    // Pokemon Home Fragment
    private var _pokemonMutableLiveData = MutableLiveData<PokemonData?>()
    private var _pokemonMasterDetailsMap = HashMap<String, PokemonMasterData>()
    private var _masterDetailsLiveData = MutableLiveData<HashMap<String, PokemonMasterData>>()
    val masterDetailsLiveData: MutableLiveData<HashMap<String, PokemonMasterData>> get() =
        _masterDetailsLiveData
    val selectedPokemonMutableLiveData = MutableLiveData<String>()
    val selectedPokemonId: LiveData<String> get() = selectedPokemonMutableLiveData
    fun setSelectedPokemonName(pokemonId: String){
        selectedPokemonMutableLiveData.value = pokemonId
    }

    // Filter Fragment
    private var _typeFilterMutableLiveData = MutableLiveData<TypeFilterData?>()
    val typeFilterLiveData : LiveData<TypeFilterData?> get() = _typeFilterMutableLiveData
    private var _genderFilterMutableLiveData = MutableLiveData<GenderFilterData?>()
    val genderFilterLiveData: LiveData<GenderFilterData?> get() = _genderFilterMutableLiveData
    private var _isFilterDataReceived = MutableLiveData<Boolean>()
    val isFilterDataReceived :LiveData<Boolean> get() = _isFilterDataReceived
    val selectedTypeFilterLiveData = MutableLiveData<HashSet<String>>()
    val selectedGenderFilterLiveData = MutableLiveData<HashSet<String>>()

    private val errorResult = "Something went wrong"

    // Detail Fragment
    private var _pokemonDetailMutableLiveData = MutableLiveData<PokemonDetailData?>()
    val pokemonDetailLiveData: LiveData<PokemonDetailData?> get() = _pokemonDetailMutableLiveData

    private var _pokemonAdditionalDetailMutableLiveData = MutableLiveData<PokemonAdditionalInfoData?>()
    val pokemonAdditionalDetailLiveData: LiveData<PokemonAdditionalInfoData?> get() =
        _pokemonAdditionalDetailMutableLiveData

    private var _pokemonStrengthAndWeaknessMutableLiveData = MutableLiveData<StrengthWeaknessData?>()
    val pokemonStrengthAndWeaknessLiveData: LiveData<StrengthWeaknessData?> get() =
        _pokemonStrengthAndWeaknessMutableLiveData

    private var _pokemonEvolutionChainMutableLiveData = MutableLiveData<EvolutionChainData?>()
    val pokemonEvolutionChainLiveData: LiveData<EvolutionChainData?> get() =
        _pokemonEvolutionChainMutableLiveData

    fun getPokemonList(){
        viewModelScope.launch {
            when(val pokemonListResponse = pokemonUseCases.getPokemonList()){
                is ApiResult.Success -> {
                    val pokemonData = pokemonListResponse.data
                    pokemonData?.let {
                        _pokemonMutableLiveData.value = pokemonData
                        getPokemonDetails(pokemonData)
                    }
                }
                is ApiResult.Error -> {
                    updateErrorResult("$errorResult in Pokemon list response")
                }
            }
        }
    }

    private suspend fun getPokemonDetails(pokemonId: String): ApiResult<PokemonDetailData> =
        pokemonUseCases.getPokemonDetails(pokemonId)

    private suspend fun getPokemonAdditionalDetails(pokemonId: String)
    : ApiResult<PokemonAdditionalInfoData> =
        pokemonUseCases.getPokemonAdditionalDetails(pokemonId)

    private suspend fun getPokemonStrengthAndWeaknessData(pokemonId: String)
    : ApiResult<StrengthWeaknessData> = pokemonUseCases.getStrengthWeakness(pokemonId)

    private fun getPokemonDetails(pokemonData: PokemonData) {
        viewModelScope.launch {
            for(pokemon in pokemonData.results){
                val pokemonDetailsDeferred = async { getPokemonDetails(pokemon.name!!) }
                val pokemonAdditionalDetailsDeferred = async { getPokemonAdditionalDetails(pokemon.name!!) }
                val strengthWeaknessDataDeferred = async { getPokemonStrengthAndWeaknessData(pokemon.name!!) }

                _pokemonMasterDetailsMap[pokemon.name!!] = PokemonMasterData()
                val pokemonDetailData = pokemonDetailsDeferred.await()
                val pokemonAdditionalData = pokemonAdditionalDetailsDeferred.await()
                val pokemonStrengthAndWeaknessData = strengthWeaknessDataDeferred.await()

                handlePokemonDetailsData(pokemonDetailData)
                handlePokemonAdditionalDetailsData(pokemonAdditionalData)
                handlePokemonStrengthAndWeaknessData(pokemonStrengthAndWeaknessData)

                _masterDetailsLiveData.value = _pokemonMasterDetailsMap
            }
        }
    }

    private fun handlePokemonDetailsData(pokemonDetailData: ApiResult<PokemonDetailData>) {
        when (pokemonDetailData) {
            is ApiResult.Success -> {
                val detailsData = pokemonDetailData.data
                detailsData?.let {
                    val pokemonMasterData = _pokemonMasterDetailsMap[detailsData.name]
                    pokemonMasterData!!.pokemonDetailData = detailsData
                    _pokemonMasterDetailsMap[detailsData.name!!] = pokemonMasterData
                }
            }
            is ApiResult.Error -> {
                updateErrorResult("$errorResult in Pokemon detail data")
            }
        }
    }

    private fun handlePokemonAdditionalDetailsData(pokemonAdditionalData: ApiResult<PokemonAdditionalInfoData>) {
        when(pokemonAdditionalData){
            is ApiResult.Success -> {
                val additionalData = pokemonAdditionalData.data
                additionalData?.let {
                    val pokemonMasterData = _pokemonMasterDetailsMap[additionalData.name]
                    pokemonMasterData!!.pokemonAdditionalInfoData = additionalData
                    _pokemonMasterDetailsMap[additionalData.name!!]= pokemonMasterData
                }
            }
            is ApiResult.Error -> {
                updateErrorResult("$errorResult in Pokemon Additional data")
            }
        }
    }

    private fun handlePokemonStrengthAndWeaknessData(pokemonStrengthAndWeaknessData: ApiResult<StrengthWeaknessData>) {
        when(pokemonStrengthAndWeaknessData){
            is ApiResult.Success -> {
                val strengthWeaknessData = pokemonStrengthAndWeaknessData.data
                strengthWeaknessData?.let {
                    val pokemonMasterData = _pokemonMasterDetailsMap[strengthWeaknessData.name]
                    pokemonMasterData!!.strengthWeaknessData = strengthWeaknessData
                    _pokemonMasterDetailsMap[strengthWeaknessData.name!!] = pokemonMasterData
                }
            }
            is ApiResult.Error -> {
                updateErrorResult("$errorResult in Pokemon Strength and weakness")
            }
        }
    }

    /**
     * updates the error result
     */
    private fun updateErrorResult(errorResult: String) {
        Timber.tag("Error").d(errorResult)
    }

    // Filter Fragment Functions

    fun resetData() {
        _masterDetailsLiveData.value = _pokemonMasterDetailsMap
    }

    private suspend fun getFilterGender(): ApiResult<GenderFilterData> {
        return pokemonUseCases.getGenderFilter()
    }

    private suspend fun getFiltersData(): ApiResult<TypeFilterData> {
        return pokemonUseCases.getTypeFilter()
    }

    fun fetchFilterData() {
        runBlocking {
            val typeResponse = async { getFiltersData() }
            val genderResponse = async { getFilterGender() }

            val gender = genderResponse.await()
            val types = typeResponse.await()
            when (types) {
                is ApiResult.Success -> {
                    val filteredTypeData = types.data
                    filteredTypeData?.let {
                        _typeFilterMutableLiveData.value = it
                    }
                }
                is ApiResult.Error -> {
                    updateErrorResult(errorResult)
                }
            }

            when (gender) {
                is ApiResult.Success -> {
                    val filteredGenderData = gender.data
                    filteredGenderData?.let {
                        _genderFilterMutableLiveData.value = it
                    }
                }
                is ApiResult.Error -> {
                    updateErrorResult(errorResult)
                }
            }
            _isFilterDataReceived.value = true
        }
    }

    fun applyFilters() {
        if (selectedTypeFilterLiveData.value?.isEmpty() == true) {
            resetData()
            return
        }
        val filteredData = HashMap<String, PokemonMasterData>()
        _pokemonMasterDetailsMap.forEach { (key, value) ->
            // filter for
            val list = selectedTypeFilterLiveData.value?.toList() // filters list
            if (list != null) {
                for (string in list) {
                    val typesList =
                        value.pokemonDetailData?.types?.map { types: Types -> types.type?.name }
                    if ((typesList != null) && typesList.contains(string)) {
                        filteredData[key] = value
                    }
                }
            }
        }
        masterDetailsLiveData.value = filteredData
    }

    // Details Fragment

    fun getPokemonDetail(value: String?) {
        val dataKey = masterDetailsLiveData.value
        _pokemonDetailMutableLiveData.value = dataKey?.get(value)?.pokemonDetailData
        _pokemonAdditionalDetailMutableLiveData.value =
            dataKey?.get(value)?.pokemonAdditionalInfoData
        getPokemonStrengthWeaknessInfo(pokemonDetailLiveData.value?.id.toString())

        getEvolutionChain(dataKey?.get(value)?.pokemonDetailData?.id!!.toString())
    }

    private fun getPokemonStrengthWeaknessInfo(idPokedex: String) {
        viewModelScope.launch {
            when (val pokemonStrengthWeaknessInfo =
                pokemonUseCases.getStrengthWeakness(idPokedex)) {
                is ApiResult.Success -> {
                    val pokemonStrengthWeaknessData = pokemonStrengthWeaknessInfo.data
                    pokemonStrengthWeaknessData?.let {
                        _pokemonStrengthAndWeaknessMutableLiveData.value = pokemonStrengthWeaknessData
                    }
                }
                is ApiResult.Error -> {
//                    updateErrorResult(pokemonListInfo)
                }
            }
        }
    }

    private fun getEvolutionChain(id: String) {
//        val id = evolutionUrl?.replace("https://pokeapi.co/api/v2/evolution-chain/", "")
//            ?.replace("/", "")
        viewModelScope.launch {
            when (val evolutionDataInfo =
                pokemonUseCases.getEvolutionChain(id)) {
                is ApiResult.Success -> {
                    val evolutionDataInfoData = evolutionDataInfo.data
                    evolutionDataInfoData?.let {
                        _pokemonEvolutionChainMutableLiveData.value = evolutionDataInfoData
                    }
                }
                is ApiResult.Error -> {
                    updateErrorResult(errorResult)
                }
            }
        }
    }
}