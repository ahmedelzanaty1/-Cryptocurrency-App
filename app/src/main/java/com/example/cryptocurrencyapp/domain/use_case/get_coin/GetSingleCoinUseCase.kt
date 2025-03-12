package com.example.cryptocurrencyapp.domain.use_case.get_coin

import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.data.remote.dto.toCoinDetails
import com.example.cryptocurrencyapp.domain.model.CoinsDetails
import com.example.cryptocurrencyapp.domain.repositry.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetSingleCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinid: String) : Flow<Resource<CoinsDetails>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinid).toCoinDetails()
            emit(Resource.Success(coin))

        }catch (e: Exception){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))

        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))

        }

    }
}