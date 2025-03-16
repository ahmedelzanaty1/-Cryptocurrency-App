package com.example.cryptocurrencyapp.presentation.coins_list

import com.example.cryptocurrencyapp.domain.model.Coins

data class CoinsState(
    val isLoading: Boolean = false,
    val coins: List<Coins> = emptyList(),
    val error: String = ""
)
