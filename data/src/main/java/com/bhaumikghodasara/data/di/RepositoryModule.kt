package com.bhaumikghodasara.data.di

import com.bhaumikghodasara.data.errorHandler.GeneralErrorHandlerImpl
import com.bhaumikghodasara.data.repositories.PokemonRepositoryImpl
import com.bhaumikghodasara.data.repositories.dataSource.PokemonRemoteDataSource
import com.bhaumikghodasara.data.repositories.dataSource.PokemonRemoteDataSourceImpl
import com.bhaumikghodasara.domain.entities.common.ErrorHandler
import com.bhaumikghodasara.domain.repository.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun providePokemonRepoImpl(
        pokemonRepositoryImpl: PokemonRepositoryImpl
    ): PokemonRepository

    @Binds
    abstract fun provideRemoteDataSource(
        remoteDataSourceImpl: PokemonRemoteDataSourceImpl
    ): PokemonRemoteDataSource

    @Binds
    abstract fun provideErrorHandler(generalErrorHandlerImpl: GeneralErrorHandlerImpl)
            : ErrorHandler
}