package com.bhaumikghodasara.data

import com.bhaumikghodasara.data.api.PokemonAPI
import com.bhaumikghodasara.data.errorHandler.GeneralErrorHandlerImpl
import com.bhaumikghodasara.data.mappers.*
import com.bhaumikghodasara.data.mocks.MockApiResponses
import com.bhaumikghodasara.data.repositories.PokemonRepositoryImpl
import com.bhaumikghodasara.data.repositories.dataSource.PokemonRemoteDataSource
import com.bhaumikghodasara.data.repositories.dataSource.PokemonRemoteDataSourceImpl
import com.bhaumikghodasara.domain.entities.common.ApiResult
import com.bhaumikghodasara.domain.repository.PokemonRepository
import com.google.gson.GsonBuilder
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class PokemonRepositoryAndDataSourceTest {
    private val mockWebServer = MockWebServer()
    lateinit var okHttpClient: OkHttpClient
    lateinit var service: PokemonAPI
    lateinit var remoteDataSource: PokemonRemoteDataSource
    lateinit var pokemonRepository: PokemonRepository

    private val pokemonListEntityMapper = PokemonListEntityMapper()
    private val pokemonDetailEntityMapper = PokemonDetailEntityMapper()
    private val pokemonAdditionalInfoEntityMapper = PokemonAdditionalInfoEntityMapper()
    private val strengthWeaknessMapper = StrengthWeaknessMapper()
    private val genderFilterEntityMapper = GenderFilterEntityMapper()
    private val typeFilterEntityMapper = TypeFilterEntityMapper()
    private val evolutionChainEntityMapper = EvolutionChainEntityMapper()
    private val errorHandler = GeneralErrorHandlerImpl()

    @Before
    fun init(){
        mockWebServer.start(8000)
        val BASE_URL = mockWebServer.url("/").toString()

        okHttpClient = OkHttpClient
            .Builder()
            .build()

        service = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(okHttpClient)
            .build()
            .create(PokemonAPI::class.java)

        remoteDataSource = PokemonRemoteDataSourceImpl(
            service,
            pokemonListEntityMapper,
            pokemonDetailEntityMapper,
            pokemonAdditionalInfoEntityMapper,
            strengthWeaknessMapper,
            genderFilterEntityMapper,
            typeFilterEntityMapper,
            evolutionChainEntityMapper,
            errorHandler
        )

        pokemonRepository = PokemonRepositoryImpl(remoteDataSource)
    }

    @After
    fun tearDown(){
        mockWebServer.shutdown()
    }

    // getPokemonList
    @Test
    fun `GIVEN getPokemonList WHEN called THEN returns list of pokemon`() = runTest {
            val jsonString = MockApiResponses.pokemonList
            mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(jsonString))
            val resp = pokemonRepository.getPokemonList()
            Assert.assertEquals(1281, resp.data?.count)
    }

    @Test
    fun `GIVEN getPokemonList WHEN called THEN returns 404 Not Found`() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(400))
        val response = pokemonRepository.getPokemonList()
        Assert.assertEquals("Not found",response.message)
    }

    @Test
    fun `GIVEN getPokemonList WHEN called THEN some exception while processing`() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody("""{"count" = "1281"}"""))
        val resp = pokemonRepository.getPokemonList()
        Assert.assertSame(resp::class.java, ApiResult.Error::class.java)
    }

    // getPokemonDetails
    @Test
    fun `GIVEN getPokemonDetails WHEN called THEN returns details of pokemon`() = runTest {
        val jsonString = MockApiResponses.pokemonDetails
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(jsonString))
        val resp = pokemonRepository.getPokemonDetails("6")
        Assert.assertEquals(6, resp.data?.id)
        Assert.assertEquals(905, resp.data?.weight)
        Assert.assertEquals("charizard", resp.data?.name)
    }

    @Test
    fun `GIVEN getPokemonDetails WHEN called THEN returns 404 Not Found`() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(400))
        val response = pokemonRepository.getPokemonDetails("6")
        Assert.assertEquals("Not found",response.message)
    }

    @Test
    fun `GIVEN getPokemonDetails WHEN called THEN some exception while processing`() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody("""{"count" = "1281"}"""))
        val resp = pokemonRepository.getPokemonDetails("6")
        Assert.assertSame(resp::class.java, ApiResult.Error::class.java)
    }

    // getPokemonAdditionalDetails
    @Test
    fun `GIVEN getPokemonAdditionalDetails WHEN called THEN returns additional details of pokemon`() = runTest {
        val jsonString = MockApiResponses.pokemonAdditionalDetails
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(jsonString))
        val resp = pokemonRepository.getPokemonAdditionalDetails("6")
        Assert.assertEquals(6, resp.data?.id)
        Assert.assertEquals(2, resp.data?.eggGroups?.size)
        Assert.assertEquals("charizard", resp.data?.name)
    }

    @Test
    fun `GIVEN getPokemonAdditionalDetails WHEN called THEN returns 404 Not Found`() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(400))
        val response = pokemonRepository.getPokemonAdditionalDetails("6")
        Assert.assertEquals("Not found",response.message)
    }

    @Test
    fun `GIVEN getPokemonAdditionalDetails WHEN called THEN some exception while processing`() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody("""{"count" = "1281"}"""))
        val resp = pokemonRepository.getPokemonAdditionalDetails("6")
        Assert.assertSame(resp::class.java, ApiResult.Error::class.java)
    }

    // getPokemonStrengthAndWeaknessData
    @Test
    fun `GIVEN getPokemonStrengthAndWeaknessData WHEN called THEN returns strength and weaknesses of pokemon`() = runTest {
        val jsonString = MockApiResponses.pokemonSterengthWeakness
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(jsonString))
        val resp = pokemonRepository.getStrengthWeakness("6")
        Assert.assertEquals(6, resp.data?.id)
        Assert.assertEquals("rock", resp.data?.name)
    }

    @Test
    fun `GIVEN getPokemonStrengthAndWeaknessData WHEN called THEN returns 404 Not Found`() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(400))
        val response = pokemonRepository.getStrengthWeakness("6")
        Assert.assertEquals("Not found",response.message)
    }

    @Test
    fun `GIVEN getPokemonStrengthAndWeaknessData WHEN called THEN some exception while processing`() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody("""{"count" = "1281"}"""))
        val resp = pokemonRepository.getStrengthWeakness("6")
        Assert.assertSame(resp::class.java, ApiResult.Error::class.java)
    }

    // getTypeFilter
    @Test
    fun `GIVEN getTypeFilter WHEN called THEN returns types of pokemons`() = runTest {
        val jsonString = MockApiResponses.pokemonTypes
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(jsonString))
        val resp = pokemonRepository.getTypeFilter()
        Assert.assertEquals(20, resp.data?.typeFilters?.size)
    }

    @Test
    fun `GIVEN getTypeFilter WHEN called THEN returns 404 Not Found`() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(400))
        val response = pokemonRepository.getTypeFilter()
        Assert.assertEquals("Not found",response.message)
    }

    @Test
    fun `GIVEN getTypeFilter WHEN called THEN some exception while processing`() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody("""{"count" = "1281"}"""))
        val resp = pokemonRepository.getTypeFilter()
        Assert.assertSame(resp::class.java, ApiResult.Error::class.java)
    }

    // getGenderFilter
    @Test
    fun `GIVEN getGenderFilter WHEN called THEN returns genders of pokemons`() = runTest {
        val jsonString = MockApiResponses.pokemonGenders
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(jsonString))
        val resp = pokemonRepository.getGenderFilter()
        Assert.assertEquals(3, resp.data?.genderResult?.size)
    }

    @Test
    fun `GIVEN getGenderFilter WHEN called THEN returns 404 Not Found`() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(400))
        val response = pokemonRepository.getGenderFilter()
        Assert.assertEquals("Not found",response.message)
    }

    @Test
    fun `GIVEN getGenderFilter WHEN called THEN some exception while processing`() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody("""{"count" = "1281"}"""))
        val resp = pokemonRepository.getGenderFilter()
        Assert.assertSame(resp::class.java, ApiResult.Error::class.java)
    }

    // getPokemonEvolutionChain
    @Test
    fun `GIVEN getPokemonEvolutionChain WHEN called THEN returns evolution chain of pokemon`() = runTest {
        val jsonString = MockApiResponses.pokemonEvolutionChain
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(jsonString))
        val resp = pokemonRepository.getEvolutionChain("6")
        Assert.assertEquals(3, resp.data?.species?.size)
    }

    @Test
    fun `GIVEN getPokemonEvolutionChain WHEN called THEN returns 404 Not Found`() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(400))
        val response = pokemonRepository.getEvolutionChain("6")
        Assert.assertEquals("Not found",response.message)
    }

    @Test
    fun `GIVEN getPokemonEvolutionChain WHEN called THEN some exception while processing`() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody("""{"count" = "1281"}"""))
        val resp = pokemonRepository.getEvolutionChain("6")
        Assert.assertSame(resp::class.java, ApiResult.Error::class.java)
    }

}