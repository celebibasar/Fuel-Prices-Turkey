package com.basarcelebi.fuelpriceapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.basarcelebi.fuelpriceapp.screens.FuelPriceScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home" ){
        composable("home"){
            FuelPriceScreen(navController = navController, locationName = "İzmir")
        }
        composable("fuelprice"){
            FuelPriceScreen(navController = navController, locationName = "İzmir")
        }

    }

}