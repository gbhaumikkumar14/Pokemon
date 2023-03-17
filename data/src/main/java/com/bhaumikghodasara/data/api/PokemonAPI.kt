package com.bhaumikghodasara.data.api

import com.bhaumikghodasara.data.models.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonAPI{
    @GET("pokemon")
    suspend fun getPokemonList(): Response<PokemonListApiResponse>

    @GET("pokemon/{pokemonId}")
    suspend fun getPokemonDetails(@Path("pokemonId")pokemonId: String): Response<PokemonDetailsApiResponse>

    @GET()
    suspend fun getPokemonAdditionalDetails(@Path("pokemonId")pokemonId: String): Response<PokemonAdditionalInfo>

    @GET("type/{pokemonId}")
    suspend fun getStrengthWeakness(@Path("pokemonId") pokemonId: String): Response<StrengthWeaknessAPIResponse>

    @GET("type")
    suspend fun getTypeFilter(): Response<TypeFilterApiResponse>

    @GET("gender")
    suspend fun getGenderFilter(): Response<GenderFilterApiResponse>

    @GET("evolution-chain/{id}/")
    suspend fun getEvolutionChainData(@Path("id") id: String): Response<EvolutionChainApiResponse>
}