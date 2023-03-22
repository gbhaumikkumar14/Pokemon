package com.bhaumikghodasara.pokemon.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bhaumikghodasara.domain.usecases.PokemonUseCases
import com.bhaumikghodasara.pokemon.MainCoroutineRule
import com.bhaumikghodasara.pokemon.mocks.MockApiResults
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class PokemonViewModelTest {
    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @MockK
    private val mockUseCases = mockk<PokemonUseCases>()

    private lateinit var viewModel: PokemonViewModel

    @Before
    fun setup(){
        viewModel = PokemonViewModel(mockUseCases)
    }

    @Test
    fun `GIVEN getPokemonList WHEN called THEN receive list of pokemon and for each get all details`() = runTest {
        coEvery { mockUseCases.getPokemonList() } returns MockApiResults.getPokemonListSuccessResult()
        coEvery { mockUseCases.getPokemonDetails(any()) } returns MockApiResults.getPokemonDetailSuccessResult()
        coEvery { mockUseCases.getPokemonAdditionalDetails(any()) } returns MockApiResults.getPokemonAdditionalSuccessResult()
        coEvery { mockUseCases.getStrengthWeakness(any()) } returns MockApiResults.getPokemonStrengthWeaknessResult()

        viewModel.getPokemonList()
        advanceUntilIdle()
        val map = viewModel.masterDetailsLiveData.value
        Assert.assertNotNull(map)
        Assert.assertTrue(map?.containsKey("charizard") ?: false)
    }

    @Test
    fun `GIVEN getPokemonDetail WHEN called THEN receive list of pokemon detail, additional detail and evolution chain`() = runTest {
        coEvery { mockUseCases.getPokemonList() } returns MockApiResults.getPokemonListSuccessResult()
        coEvery { mockUseCases.getPokemonDetails(any()) } returns MockApiResults.getPokemonDetailSuccessResult()
        coEvery { mockUseCases.getPokemonAdditionalDetails(any()) } returns MockApiResults.getPokemonAdditionalSuccessResult()
        coEvery { mockUseCases.getStrengthWeakness(any()) } returns MockApiResults.getPokemonStrengthWeaknessResult()
        coEvery { mockUseCases.getEvolutionChain(any()) } returns MockApiResults.getPokemonEvolutionData()

        viewModel.getPokemonList()
        advanceUntilIdle()
        viewModel.getPokemonDetail("charizard")
        advanceUntilIdle()
        val strengthWeaknessData = viewModel.pokemonStrengthAndWeaknessLiveData.value
        Assert.assertNotNull(strengthWeaknessData)
        val evolutionChainData = viewModel.pokemonEvolutionChainLiveData.value
        Assert.assertNotNull(evolutionChainData)
    }

    @Test
    fun `GIVEN getFilterData WHEN called THEN get all the genders, types list`() = runTest {
        coEvery { mockUseCases.getTypeFilter() } returns MockApiResults.getTypeFilterData()
        coEvery { mockUseCases.getGenderFilter() } returns MockApiResults.getGenderFilterData()

        viewModel.fetchFilterData()
        advanceUntilIdle()
        val isFilterDataReceived = viewModel.isFilterDataReceived.value
        Assert.assertTrue(isFilterDataReceived ?: false)
    }

    @Test
    fun `GIVEN setSelectedPokemonName WHEN called THEN selected pokemon name should change`() = runTest {
        viewModel.resetData()
        viewModel.setSelectedPokemonName("charizard")
        val selectedPokemonName = viewModel.selectedPokemonId.value
        Assert.assertEquals("charizard", selectedPokemonName)
    }

    @Test
    fun `GIVEN WHEN THEN`() = runTest {
        val type = hashSetOf("Flying", "Rock")
        val gender = hashSetOf("Male")

        viewModel.selectedGenderFilterLiveData.value = gender
        viewModel.selectedTypeFilterLiveData.value = type

        viewModel.applyFilters()
    }
}