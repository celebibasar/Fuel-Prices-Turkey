package com.basarcelebi.fuelpriceapp.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.basarcelebi.fuelpriceapp.models.BaseModel


@Composable
fun FuelPriceScreen(navController: NavController, locationName: String, viewModel: FuelPriceViewModel = viewModel()) {
    val dailyPrices by viewModel.dailyPrice.collectAsState()
    LaunchedEffect(Unit){
        viewModel.getDailyPrice(locationName)
    }
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Row(modifier = Modifier.padding(vertical = 32.dp)) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        navController.popBackStack()
                    },
                tint = Color.White,
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(text = locationName,color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp)
            }
            AnimatedVisibility(visible = dailyPrices is BaseModel.Success) {
                val data = dailyPrices as BaseModel.Success
                val price = data.data.first().data.gasoline
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                   Text(text = "${price}°", fontWeight = FontWeight.Bold, fontSize = 80.sp, color = Color.White)
                }

            }
            AnimatedVisibility(visible = dailyPrices is BaseModel.Loading) {
                BaseModel.Loading

            }

        }
    }
}