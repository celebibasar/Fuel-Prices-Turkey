package com.basarcelebi.fuelpriceapp.network

import com.basarcelebi.fuelpriceapp.models.IlAdi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("api/akaryakit/sehir={sehir_adi}")
    suspend fun getDailyPrice(
        @Path("sehir_adi") locationName:String,
        @Query("metric") metric:Boolean = true
    ): Response<List<IlAdi>>


}