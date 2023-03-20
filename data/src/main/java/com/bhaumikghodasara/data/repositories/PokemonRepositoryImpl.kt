package com.bhaumikghodasara.data.repositories

import com.bhaumikghodasara.data.repositories.dataSource.PokemonRemoteDataSource
import com.bhaumikghodasara.domain.entities.common.ApiResult
import com.bhaumikghodasara.domain.entities.*
import com.bhaumikghodasara.domain.repository.PokemonRepository
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(private val remoteDataSource: PokemonRemoteDataSource): PokemonRepository {
    override suspend fun getPokemonList(): ApiResult<PokemonData> {
        return remoteDataSource.getPokemonList()
    }

    override suspend fun getPokemonDetails(pokemonId: String): ApiResult<PokemonDetailData> {
        return remoteDataSource.getPokemonDetails(pokemonId)
    }

    override suspend fun getPokemonAdditionalDetails(pokemonId: String): ApiResult<PokemonAdditionalInfoData> {
        return remoteDataSource.getPokemonAdditionalDetails(pokemonId)
    }

    override suspend fun getStrengthWeakness(pokemonId: String): ApiResult<StrengthWeaknessData> {
        return remoteDataSource.getStrengthWeakness(pokemonId)
    }

    override suspend fun getTypeFilter(): ApiResult<TypeFilterData> {
        return remoteDataSource.getTypeFilter()
    }

    override suspend fun getGenderFilter(): ApiResult<GenderFilterData> {
        return remoteDataSource.getGenderFilter()
    }

    override suspend fun getEvolutionChain(pokemonId: String): ApiResult<EvolutionChainData> {
        return remoteDataSource.getEvolutionChain(pokemonId)
    }
}