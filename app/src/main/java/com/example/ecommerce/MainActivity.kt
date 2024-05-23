package com.example.ecommerce

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ecommerce.presentation.components.BottomNav
import com.example.ecommerce.presentation.navigation.Navigation
import com.example.ecommerce.presentation.navigation.Screen
import com.example.ecommerce.ui.theme.EcommerceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EcommerceTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Scaffold (
                    bottomBar = {
                        BottomAppBar {
                            BottomNav(
                                navController = navController,
                                onItemSelect = {navItem ->
                                    navController.navigate(navItem.route){
                                        launchSingleTop=true
                                        popUpTo(Screen.HomeScreen.route){
                                            saveState=true

                                        }
                                        restoreState=true
                                    }

                                }
                            )

                        }
                    }

                ){paddingValues->



                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                    ,
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation(navController = navController)
                }
                }
            }
        }
    }
}

