package com.basarcelebi.fuelpriceapp.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.basarcelebi.fuelpriceapp.models.BaseModel
import com.basarcelebi.fuelpriceapp.models.FuelPrices
import com.basarcelebi.fuelpriceapp.repositories.FuelRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class FuelPriceViewModel: ViewModel(), KoinComponent {
    private val repo: FuelRepo by inject()

    private val _dailyPrice: MutableStateFlow<BaseModel<List<FuelPrices>>> = MutableStateFlow(BaseModel.Loading)
    val dailyPrice = _dailyPrice.asStateFlow()


    fun getDailyPrice(locationKey:String){
        viewModelScope.launch {
            repo.getDailyPrice(locationKey).also {data->
                _dailyPrice.update { data }
            }
        }
    }

}