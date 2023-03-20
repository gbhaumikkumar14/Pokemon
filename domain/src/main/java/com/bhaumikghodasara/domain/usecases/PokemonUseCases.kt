package com.bhaumikghodasara.domain.usecases

import com.bhaumikghodasara.domain.entities.common.ApiResult
import com.bhaumikghodasara.domain.entities.*
import com.bhaumikghodasara.domain.repository.PokemonRepository
import javax.inject.Inject

class PokemonUseCases @Inject constructor(private val pokemonRepository: PokemonRepository) {

    suspend fun getPokemonList(): ApiResult<PokemonData> {
        return pokemonRepository.getPokemonList()
    }

    suspend fun getPokemonDetails(pokemonId: String): ApiResult<PokemonDetailData> {
        return pokemonRepository.getPokemonDetails(pokemonId)
    }

    suspend fun getPokemonAdditionalDetails(pokemonId: String): ApiResult<PokemonAdditionalInfoData> {
        return pokemonRepository.getPokemonAdditionalDetails(pokemonId)
    }

    suspend fun getStrengthWeakness(pokemonId: String): ApiResult<StrengthWeaknessData> {
        return pokemonRepository.getStrengthWeakness(pokemonId)
    }

    suspend fun getTypeFilter(): ApiResult<TypeFilterData> {
        return pokemonRepository.getTypeFilter()
    }

    suspend fun getGenderFilter(): ApiResult<GenderFilterData> {
        return pokemonRepository.getGenderFilter()
    }

    suspend fun getEvolutionChain(pokemonId: String): ApiResult<EvolutionChainData> {
        return pokemonRepository.getEvolutionChain(pokemonId)
    }
}