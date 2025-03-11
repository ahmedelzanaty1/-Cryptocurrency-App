package com.example.cryptocurrencyapp.data.remote.api

import com.example.cryptocurrencyapp.data.remote.dto.CoinsDetailsDto
import com.example.cryptocurrencyapp.data.remote.dto.CoinsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiManager {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinsDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinsDetailsDto

}