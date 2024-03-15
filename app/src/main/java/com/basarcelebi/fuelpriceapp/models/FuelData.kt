package com.basarcelebi.fuelpriceapp.models

import com.google.gson.annotations.SerializedName

data class FuelPrices(
    @SerializedName("data") val data: FuelData
)

data class FuelData(
    @SerializedName("Unleaded Gasoline") val gasoline: String,
    @SerializedName("Gas Oil") val gasOil: String,
    @SerializedName("Diesel") val diesel: String,
    @SerializedName("Fuel Oil") val fuelOil: String
)

data class Value(
    @SerializedName("Value")
    val value:Double,
    @SerializedName("Unit")
    val unit:String,
    @SerializedName("UnitType")
    val unitType:Int
)
