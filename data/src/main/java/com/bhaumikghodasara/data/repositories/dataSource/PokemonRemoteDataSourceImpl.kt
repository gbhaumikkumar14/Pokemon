package com.bhaumikghodasara.data.repositories.dataSource

import com.bhaumikghodasara.data.api.PokemonAPI
import com.bhaumikghodasara.data.mappers.*
import com.bhaumikghodasara.data.models.*
import com.bhaumikghodasara.domain.entities.common.ApiResult
import com.bhaumikghodasara.domain.entities.common.ErrorEntity
import com.bhaumikghodasara.domain.entities.common.ErrorHandler
import com.bhaumikghodasara.domain.entities.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class PokemonRemoteDataSourceImpl(
    private val service: PokemonAPI,
    private val pokemonListEntityMapper: PokemonListEntityMapper,
    private val pokemonDetailEntityMapper: PokemonDetailEntityMapper,
    private val pokemonAdditionalInfoEntityMapper: PokemonAdditionalInfoEntityMapper,
    private val strengthWeaknessMapper: StrengthWeaknessMapper,
    private val genderFilterEntityMapper: GenderFilterEntityMapper,
    private val typeFilterEntityMapper: TypeFilterEntityMapper,
    private val evolutionChainEntityMapper: EvolutionChainEntityMapper,
    private val errorHandler: ErrorHandler
): PokemonRemoteDataSource {

    override suspend fun getPokemonList(): ApiResult<PokemonData> {
        return withContext(Dispatchers.IO) {
            try {
                val apiResponse: Response<PokemonListApiResponse> = service.getPokemonList()
                val data = apiResponse.body()
                data?.let {
                    val domainResponse = pokemonListEntityMapper.mapToDomainLayer(it)
                    if (apiResponse.isSuccessful) {
                        return@withContext ApiResult.Success(domainResponse)
                    } else {
                        return@withContext ApiResult.Error(
                            message = invalid_or_missing_input,
                            errorEntity = ErrorEntity.Unknown
                        )
                    }
                } ?: run {
                    return@withContext ApiResult.Error(
                        message = not_found,
                        errorEntity = ErrorEntity.NotFound
                    )
                }
            } catch (e: Exception) {
                return@withContext ApiResult.Error(
                    message = e.localizedMessage ?: unknown_error,
                    errorEntity = errorHandler.getError(e)
                )
            }
        }
    }

    override suspend fun getPokemonDetails(pokemonId: String): ApiResult<PokemonDetailData> {
        return withContext(Dispatchers.IO) {
            try {
                val response: Response<PokemonDetailsApiResponse> =
                    service.getPokemonDetails(pokemonId)
                val pokedexDetailApiResponse = response.body()
                pokedexDetailApiResponse?.let {
                    val dataLayerResponse = pokemonDetailEntityMapper.mapToDomainLayer(pokedexDetailApiResponse)
                    if (response.isSuccessful) {
                        return@withContext ApiResult.Success(dataLayerResponse)
                    } else {
                        return@withContext ApiResult.Error(
                            message = invalid_or_missing_input,
                            errorEntity = ErrorEntity.Unknown
                        )
                    }
                } ?: run {
                    return@withContext ApiResult.Error(
                        message = not_found,
                        errorEntity = ErrorEntity.NotFound
                    )
                }
            } catch (e: Exception) {
                return@withContext ApiResult.Error(
                    message = e.localizedMessage ?: unknown_error,
                    errorEntity = errorHandler.getError(e)
                )
            }
        }
    }

    override suspend fun getPokemonAdditionalDetails(pokemonId: String): ApiResult<PokemonAdditionalInfoData> {
        return withContext(Dispatchers.IO) {
            try {
                val response: Response<PokemonAdditionalInfo> =
                    service.getPokemonAdditionalDetails(pokemonId)
                val pokemonAdditionalInfo = response.body()
                pokemonAdditionalInfo?.let {
                    val dataLayerResponse = pokemonAdditionalInfoEntityMapper.mapToDomainLayer(pokemonAdditionalInfo)
                    if (response.isSuccessful) {
                        return@withContext ApiResult.Success(dataLayerResponse)
                    } else {
                        return@withContext ApiResult.Error(
                            message = invalid_or_missing_input,
                            errorEntity = ErrorEntity.Unknown
                        )
                    }
                } ?: run {
                    return@withContext ApiResult.Error(
                        message = not_found,
                        errorEntity = ErrorEntity.NotFound
                    )
                }
            } catch (e: Exception) {
                return@withContext ApiResult.Error(
                    message = e.localizedMessage ?: unknown_error,
                    errorEntity = errorHandler.getError(e)
                )
            }
        }
    }

    override suspend fun getStrengthWeakness(pokemonId: String): ApiResult<StrengthWeaknessData> {
        return withContext(Dispatchers.IO) {
            try {
                val response: Response<StrengthWeaknessAPIResponse> =
                    service.getStrengthWeakness(pokemonId)
                val pokemonStrengthWeaknessInfo = response.body()
                pokemonStrengthWeaknessInfo?.let {
                    val dataLayerResponse = strengthWeaknessMapper.mapToDomainLayer(pokemonStrengthWeaknessInfo)
                    if (response.isSuccessful) {
                        return@withContext ApiResult.Success(dataLayerResponse)
                    } else {
                        return@withContext ApiResult.Error(
                            message = invalid_or_missing_input,
                            errorEntity = ErrorEntity.Unknown
                        )
                    }
                } ?: run {
                    return@withContext ApiResult.Error(
                        message = not_found,
                        errorEntity = ErrorEntity.NotFound
                    )
                }
            } catch (e: Exception) {
                return@withContext ApiResult.Error(
                    message = e.localizedMessage ?: unknown_error,
                    errorEntity = errorHandler.getError(e)
                )
            }
        }
    }

    override suspend fun getTypeFilter(): ApiResult<TypeFilterData> {
        return withContext(Dispatchers.IO) {
            try {
                val response: Response<TypeFilterApiResponse> =
                    service.getTypeFilter()
                val typeFilterDataInfo = response.body()
                typeFilterDataInfo?.let {
                    val dataLayerResponse =
                        typeFilterEntityMapper.mapToDomainLayer(typeFilterDataInfo)
                    if (response.isSuccessful) {
                        return@withContext ApiResult.Success(dataLayerResponse)
                    } else {
                        return@withContext ApiResult.Error(
                            message = invalid_or_missing_input,
                            errorEntity = ErrorEntity.Unknown
                        )
                    }
                } ?: run {
                    return@withContext ApiResult.Error(
                        message = not_found,
                        errorEntity = ErrorEntity.NotFound
                    )
                }
            } catch (e: Exception) {
                return@withContext ApiResult.Error(
                    message = e.localizedMessage ?: unknown_error,
                    errorEntity = errorHandler.getError(e)
                )
            }
        }
    }

    override suspend fun getGenderFilter(): ApiResult<GenderFilterData> {
        return withContext(Dispatchers.IO) {
            try {
                val response: Response<GenderFilterApiResponse> =
                    service.getGenderFilter()
                val genderFilterInfo = response.body()
                genderFilterInfo?.let {
                    val dataLayerResponse =
                        genderFilterEntityMapper.mapToDomainLayer(genderFilterInfo)
                    if (response.isSuccessful) {
                        return@withContext ApiResult.Success(dataLayerResponse)
                    } else {
                        return@withContext ApiResult.Error(
                            message = invalid_or_missing_input,
                            errorEntity = ErrorEntity.Unknown
                        )
                    }
                } ?: run {
                    return@withContext ApiResult.Error(
                        message = not_found,
                        errorEntity = ErrorEntity.NotFound
                    )
                }
            } catch (e: Exception) {
                return@withContext ApiResult.Error(
                    message = e.localizedMessage ?: unknown_error,
                    errorEntity = errorHandler.getError(e)
                )
            }
        }
    }

    override suspend fun getEvolutionChain(pokemonId: String): ApiResult<EvolutionChainData> {
        return withContext(Dispatchers.IO) {
            try {
                val response: Response<EvolutionChainApiResponse> =
                    service.getEvolutionChainData(pokemonId)
                val evolutionChainInfo = response.body()
                evolutionChainInfo?.let {
                    val dataLayerResponse =
                        evolutionChainEntityMapper.mapToDomainLayer(evolutionChainInfo)
                    if (response.isSuccessful) {
                        return@withContext ApiResult.Success(dataLayerResponse)
                    } else {
                        return@withContext ApiResult.Error(
                            message = invalid_or_missing_input,
                            errorEntity = ErrorEntity.Unknown
                        )
                    }
                } ?: run {
                    return@withContext ApiResult.Error(
                        message = not_found,
                        errorEntity = ErrorEntity.NotFound
                    )
                }
            } catch (e: Exception) {
                return@withContext ApiResult.Error(
                    message = e.localizedMessage ?: unknown_error,
                    errorEntity = errorHandler.getError(e)
                )
            }
        }
    }

    companion object{
        private const val unknown_error = "Unknown Error"
        private const val invalid_or_missing_input = "Either input missing or invalid"
        private const val not_found = "Not found"
    }
}