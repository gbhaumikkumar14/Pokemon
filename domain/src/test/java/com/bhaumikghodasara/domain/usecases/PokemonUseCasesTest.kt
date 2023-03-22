package com.bhaumikghodasara.domain.usecases

import com.bhaumikghodasara.domain.entities.*
import com.bhaumikghodasara.domain.entities.common.ApiResult
import com.bhaumikghodasara.domain.repository.PokemonRepository
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class PokemonUseCasesTest {
    @MockK
    private val mockRepository = mockk<PokemonRepository>()

    private lateinit var pokemonUseCases: PokemonUseCases

    @Before
    fun setup(){
        pokemonUseCases = PokemonUseCases(mockRepository)
    }

    @Test
    fun `GIVEN getPokemonList WHEN called THEN should return pokemonList`() = runTest {
        coEvery { mockRepository.getPokemonList() } returns
                ApiResult.Success(PokemonData(results = listOf(Results())))
        val result = pokemonUseCases.getPokemonList()
        Assert.assertNotNull(result)
    }

    @Test
    fun `GIVEN getPokemonDetails WHEN called THEN should return pokemon details`() = runTest {
        coEvery { mockRepository.getPokemonDetails("6") } returns
                ApiResult.Success(PokemonDetailData(
                    abilities = listOf(Abilities(ability = Ability())),
                    stats = listOf(Stats()),
                    types = listOf(Types())
                ))
        val result = pokemonUseCases.getPokemonDetails("6")
        Assert.assertNotNull(result)
    }

    @Test
    fun `GIVEN getPokemonAdditionalDetails WHEN called THEN should return pokemon additional details`() = runTest {
        coEvery { mockRepository.getPokemonAdditionalDetails("6") } returns
                ApiResult.Success(PokemonAdditionalInfoData())
        val result = pokemonUseCases.getPokemonAdditionalDetails("6")
        Assert.assertNotNull(result)
    }

    @Test
    fun `GIVEN getStrengthWeakness WHEN called THEN should return pokemon strength and weakness`() = runTest {
        coEvery { mockRepository.getStrengthWeakness("6") } returns
                ApiResult.Success(StrengthWeaknessData(
                    names = listOf(Names()),
                    pokemon = listOf(Pokemon())
                ))
        val result = pokemonUseCases.getStrengthWeakness("6")
        Assert.assertNotNull(result)
    }

    @Test
    fun `GIVEN getTypeFilter WHEN called THEN should return pokemon types`() = runTest {
        coEvery { mockRepository.getTypeFilter() } returns
                ApiResult.Success(TypeFilterData())
        val result = pokemonUseCases.getTypeFilter()
        Assert.assertNotNull(result)
    }

    @Test
    fun `GIVEN getGenderFilter WHEN called THEN should return pokemon genders`() = runTest {
        coEvery { mockRepository.getGenderFilter() } returns
                ApiResult.Success(GenderFilterData())
        val result = pokemonUseCases.getGenderFilter()
        Assert.assertNotNull(result)
    }

    @Test
    fun `GIVEN getEvolutionChain WHEN called THEN should return pokemon evolution chain`() = runTest {
        coEvery { mockRepository.getEvolutionChain("6") } returns
                ApiResult.Success(EvolutionChainData(
                    species = listOf(Species())
                ))
        val result = pokemonUseCases.getEvolutionChain("6")
        Assert.assertNotNull(result)
    }
}