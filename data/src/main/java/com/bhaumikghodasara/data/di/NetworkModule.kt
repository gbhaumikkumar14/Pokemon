package com.bhaumikghodasara.data.di

import com.bhaumikghodasara.data.BuildConfig
import com.bhaumikghodasara.data.api.ErrorInterceptor
import com.bhaumikghodasara.data.api.PokemonAPI
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofitClient(client: OkHttpClient): Retrofit{
        return Retrofit.Builder().apply {
            baseUrl(BuildConfig.BASE_URL)
            client(client)
            addConverterFactory(
                GsonConverterFactory.create(GsonBuilder().create())
            )
        }.build()
    }

    @Provides
    @Singleton
    fun provideOkHTTPClient(headerInterceptor: Interceptor): OkHttpClient{
        return OkHttpClient().newBuilder().apply {
            readTimeout(READ_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
            writeTimeout(WRITE_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
            connectTimeout(CONNECTION_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
            addInterceptor(headerInterceptor)
        }.build()
    }

    @Provides
    @Singleton
    fun provideHeaderInterceptor(): Interceptor = ErrorInterceptor()

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): PokemonAPI = retrofit.create(PokemonAPI::class.java)

    companion object{
        private const val READ_TIMEOUT_SECONDS = 30
        private const val WRITE_TIMEOUT_SECONDS = 30
        private const val CONNECTION_TIMEOUT_SECONDS = 10
    }
}