package com.example.cryptocurrencyapp.domain.repositry

import com.example.cryptocurrencyapp.data.remote.dto.CoinsDetailsDto
import com.example.cryptocurrencyapp.data.remote.dto.CoinsDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinsDto>

    suspend fun getCoinById(coinId: String): CoinsDetailsDto

}