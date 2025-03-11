package com.example.cryptocurrencyapp.data.repositry

import com.example.cryptocurrencyapp.data.remote.api.ApiManager
import com.example.cryptocurrencyapp.data.remote.dto.CoinsDetailsDto
import com.example.cryptocurrencyapp.data.remote.dto.CoinsDto
import com.example.cryptocurrencyapp.domain.repositry.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: ApiManager
)  : CoinRepository {
    override suspend fun getCoins(): List<CoinsDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinsDetailsDto {
        return api.getCoinById(coinId)

    }

}