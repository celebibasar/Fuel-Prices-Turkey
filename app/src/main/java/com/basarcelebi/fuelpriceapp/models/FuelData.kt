package com.basarcelebi.fuelpriceapp.models

import com.google.gson.annotations.SerializedName

data class FuelPrices(
    @SerializedName("Ilce_Adi") val ilceAdi: IlAdi
)

data class IlAdi(
    @SerializedName("Kursunsuz_95(Excellium95)_TL_lt") val kursunsuz95: String,
    @SerializedName("Gazyagi_TL_lt") val gazyagi: String,
    @SerializedName("Motorin(Eurodiesel)_TL_lt") val motorinEurodiesel: String,
    @SerializedName("Motorin(Excellium_Eurodiesel)_TL_lt") val motorinExcelliumEurodiesel: String,
    @SerializedName("Kalorifer_Yakiti_TL_kg") val kaloriferYakiti: String,
    @SerializedName("Fuel_Oil_TL_Kg") val fuelOil: String,
    @SerializedName("Yüksek_Kükürtlü_Fuel_Oil_TL_kg") val yuksekKukurtluFuelOil: String,
    @SerializedName("Otogaz_TL_lt") val otogaz: String
)
