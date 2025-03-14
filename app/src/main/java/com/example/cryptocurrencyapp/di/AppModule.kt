package com.example.cryptocurrencyapp.di

import com.example.cryptocurrencyapp.common.Constants
import com.example.cryptocurrencyapp.data.remote.api.ApiManager
import com.example.cryptocurrencyapp.data.repositry.CoinRepositoryImpl
import com.example.cryptocurrencyapp.domain.repositry.CoinRepository
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
    fun ProvideRetrofit () : ApiManager{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiManager::class.java)
    }
    @Provides
    @Singleton
    fun ProvideRepository(api: ApiManager) : CoinRepository {
        return CoinRepositoryImpl(api)

    }
}