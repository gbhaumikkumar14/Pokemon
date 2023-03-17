package com.bhaumikghodasara.data.repositories.dataSource

import com.bhaumikghodasara.data.api.PokemonAPI
import com.bhaumikghodasara.domain.common.ApiResult
import com.bhaumikghodasara.domain.entities.*

class PokemonRemoteDataSourceImpl(service: PokemonAPI): PokemonRemoteDataSource {
    override suspend fun getPokemonList(): ApiResult<PokemonData> {
        TODO("Not yet implemented")
    }

    override suspend fun getPokemonDetails(pokemonId: String): ApiResult<PokemonDetailData> {
        TODO("Not yet implemented")
    }

    override suspend fun getPokemonAdditionalDetails(pokemonId: String): ApiResult<PokemonAdditionalInfoData> {
        TODO("Not yet implemented")
    }

    override suspend fun getStrengthWeakness(pokemonId: String): ApiResult<StrengthWeaknessData> {
        TODO("Not yet implemented")
    }

    override suspend fun getTypeFilter(): ApiResult<TypeFilterData> {
        TODO("Not yet implemented")
    }

    override suspend fun getGenderFilter(): ApiResult<GenderFilterData> {
        TODO("Not yet implemented")
    }

    override suspend fun getEvolutionChain(pokemonId: String): ApiResult<EvolutionChainData> {
        TODO("Not yet implemented")
    }
}