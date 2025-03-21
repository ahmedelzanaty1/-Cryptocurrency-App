package com.example.cryptocurrencyapp.presentation.coin_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.domain.use_case.get_coin.GetSingleCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor(
    private val getCoinUseCase: GetSingleCoinUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(CoinState())
    val state : State<CoinState> = _state
    init {
        getcoin(
            savedStateHandle.get<String>("coinId") ?: ""
        )
    }

    private fun getcoin(coinId: String){
        getCoinUseCase(coinId).onEach {result ->
            when(result){
                is Resource.Loading ->{
                    _state.value = CoinState(isLoading = true)
                }
                is Resource.Error ->{
                    _state.value = CoinState(error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Success ->{
                    _state.value = CoinState(coin = result.data )

                }
            }
        }.launchIn(viewModelScope)
    }
}