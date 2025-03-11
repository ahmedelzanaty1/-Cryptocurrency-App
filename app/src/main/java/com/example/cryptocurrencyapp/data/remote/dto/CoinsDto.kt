package com.example.cryptocurrencyapp.data.remote.dto

import com.example.cryptocurrencyapp.domain.model.Coins
import com.google.gson.annotations.SerializedName

data class CoinsDto(

	@field:SerializedName("symbol")
	val symbol: String? = null,

	@field:SerializedName("is_active")
	val isActive: Boolean? = null,

	@field:SerializedName("is_new")
	val isNew: Boolean? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("rank")
	val rank: Int? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("type")
	val type: String? = null
)
fun CoinsDto.toCoin(): Coins {
	return Coins(
		id= id ?: "" ,
		isActive= isActive ?: false ,
		name= name ?: "" ,
		rank= rank ?: 0 ,
		symbol= symbol ?: ""

	)
}