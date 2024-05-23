package com.example.ecommerce.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ecommerce.presentation.onboarding.OnBoarding

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination =Screen.OnBoardingScreen.route ) {

        composable(route=Screen.OnBoardingScreen.route){
            OnBoarding {
                navController.navigate(Screen.HomeScreen.route)
            }

        }

        composable(route=Screen.HomeScreen.route){
            Box (
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Text(text = "Home")
            }

        }
        composable(route=Screen.ShopScreen.route){
            Box (
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Text(text = "Shope")
            }
        }
        composable(route=Screen.FavScreen.route){
            Box (
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Text(text = "FavScreen")
            }
        }
        composable(route=Screen.SearchScreen.route){
            Box (
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Text(text = "Search")
            }
        }

    }

}

sealed class Screen(val route:String){
    object OnBoardingScreen:Screen("onboarding_screen")
    object HomeScreen:Screen("home_screen")
    object ShopScreen:Screen("shop_screen")
    object FavScreen:Screen("fav_screeen")
    object SearchScreen:Screen("search_screen")
}