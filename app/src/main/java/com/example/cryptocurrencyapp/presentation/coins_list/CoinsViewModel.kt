package com.example.cryptocurrencyapp.presentation.coins_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.domain.use_case.get_coins.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinsViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinUseCase
) : ViewModel() {
    private val _state = mutableStateOf(CoinsState())
    val state : State<CoinsState> = _state
    init {
        getcoins()
    }

    private fun getcoins(){
        getCoinsUseCase().onEach {result ->
            when(result){
                is Resource.Loading ->{
                    _state.value = CoinsState(isLoading = true)
                }
                is Resource.Error ->{
                    _state.value = CoinsState(error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Success ->{
                    _state.value = CoinsState(coins = result.data ?: emptyList())

                }
            }
        }.launchIn(viewModelScope)
    }
}