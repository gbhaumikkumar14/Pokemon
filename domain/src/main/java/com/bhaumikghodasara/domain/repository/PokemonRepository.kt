package com.bhaumikghodasara.domain.repository

import com.bhaumikghodasara.domain.common.ApiResult
import com.bhaumikghodasara.domain.entities.*

interface PokemonRepository {
    suspend fun getPokemonList(): ApiResult<PokemonData>

    suspend fun getPokemonDetails(pokemonId: String): ApiResult<PokemonDetailData>

    suspend fun getPokemonAdditionalDetails(pokemonId: String): ApiResult<PokemonAdditionalInfoData>

    suspend fun getStrengthWeakness(pokemonId: String): ApiResult<StrengthWeaknessData>

    suspend fun getTypeFilter(): ApiResult<TypeFilterData>

    suspend fun getGenderFilter(): ApiResult<GenderFilterData>

    suspend fun getEvolutionChain(pokemonId: String): ApiResult<EvolutionChainData>
}