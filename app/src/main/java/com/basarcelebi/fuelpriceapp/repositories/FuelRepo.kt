package com.basarcelebi.fuelpriceapp.repositories

import com.basarcelebi.fuelpriceapp.models.BaseModel
import com.basarcelebi.fuelpriceapp.models.IlAdi

interface FuelRepo {
    suspend fun getDailyPrice(locationName: String): BaseModel<List<IlAdi>>
}