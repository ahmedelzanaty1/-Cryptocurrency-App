package com.example.cryptocurrencyapp.presentation.coin_details

import com.example.cryptocurrencyapp.domain.model.CoinsDetails

data class CoinState(
    val isLoading: Boolean = false,
    val coin: CoinsDetails? = null,
    val error: String = ""
)
