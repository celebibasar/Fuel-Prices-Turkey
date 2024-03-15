package com.basarcelebi.fuelpriceapp.repositories

import com.basarcelebi.fuelpriceapp.models.BaseModel
import com.basarcelebi.fuelpriceapp.models.FuelPrices
import com.basarcelebi.fuelpriceapp.network.Api
import retrofit2.Response

class FuelRepoImpl(private val api: Api):FuelRepo {


    override suspend fun getDailyPrice(locationName: String): BaseModel<List<FuelPrices>> {
        return request {
            api.getDailyPrice(locationName = locationName)
        }
    }


}

suspend fun<T>request(request:suspend ()-> Response<T>):BaseModel<T>
{
    try {
        request().also {
            return if(it.isSuccessful){
                BaseModel.Success(it.body()!!)
            }else{
                BaseModel.Error(it.errorBody()?.string().toString())
            }
        }
    }catch (e:Exception){
        return BaseModel.Error(e.message.toString())
    }
}