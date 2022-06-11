package com.example.compose_marvel._product.di

import com.example.compose_marvel.network.ApiPath
import com.example.compose_marvel.network.MarvelApi
import com.example.compose_marvel.network.repository.MarvelRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providerMarvelRepository(api: MarvelApi) = MarvelRepository(api = api);

    @Provides
    @Singleton
    fun provideMarvelApi(): MarvelApi {
        return Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(ApiPath.baseUrl)
            .build()
            .create(MarvelApi::class.java)
    }
}