package com.bhaumikghodasara.pokemon.mocks

import com.bhaumikghodasara.domain.entities.*
import com.bhaumikghodasara.domain.entities.common.ApiResult
import com.google.gson.Gson

object MockApiResults {
    fun getPokemonListSuccessResult(): ApiResult<PokemonData> {
        return ApiResult.Success(
             Gson().fromJson(MockApiResponses.pokemonList, PokemonData::class.java)
        )
    }

    fun getPokemonDetailSuccessResult(): ApiResult<PokemonDetailData> {
        return ApiResult.Success(
            Gson().fromJson(MockApiResponses.pokemonDetails, PokemonDetailData::class.java)
        )
    }

    fun getPokemonAdditionalSuccessResult(): ApiResult<PokemonAdditionalInfoData> {
        return ApiResult.Success(
            Gson().fromJson(MockApiResponses.pokemonAdditionalDetails, PokemonAdditionalInfoData::class.java)
        )
    }

    fun getPokemonStrengthWeaknessResult(): ApiResult<StrengthWeaknessData> {
        return ApiResult.Success(
            Gson().fromJson(MockApiResponses.pokemonSterengthWeakness, StrengthWeaknessData::class.java)
        )
    }

    fun getPokemonEvolutionData(): ApiResult<EvolutionChainData> {
        return ApiResult.Success(
            Gson().fromJson(MockApiResponses.pokemonEvolutionChain, EvolutionChainData::class.java)
        )
    }

    fun getTypeFilterData(): ApiResult<TypeFilterData> {
        return ApiResult.Success(
            Gson().fromJson(MockApiResponses.pokemonTypes, TypeFilterData::class.java)
        )
    }
    fun getGenderFilterData(): ApiResult<GenderFilterData> {
        return ApiResult.Success(
            Gson().fromJson(MockApiResponses.pokemonGenders, GenderFilterData::class.java)
        )
    }
}