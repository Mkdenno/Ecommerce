package com.example.ecommerce.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Sell
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Sell
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.ecommerce.presentation.navigation.Screen

@Composable
fun BottomNav(
    navController: NavController,
    onItemSelect:(NavItem)->Unit
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination=backStackEntry?.destination

    val destination= navItems.any{
        it.route==currentDestination?.route
    }

//    val mutableInteraction= remember {
//        MutableInteractionSource()
//    }

    if (destination){
        NavigationBar {
            navItems.forEach{navItem ->
                val selected=navItem.route==currentDestination?.route
                val iconColor by animateColorAsState(
                    targetValue =if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primary.copy(1f),
                    label = "iconColor",
                    animationSpec = tween(
                        easing = EaseInOut
                    )
                )

                val iconScale by animateFloatAsState(
                    targetValue = if (selected) 1f else .9f,
                    label = "Icon Scale",
                    animationSpec = spring(
                        visibilityThreshold = .000005f,
                        stiffness =Spring.StiffnessLow,
                        dampingRatio = Spring.DampingRatioMediumBouncy
                    )
                )

                Box(
                    modifier = Modifier
                        .weight(1f / navItems.size)
                        .clickable { onItemSelect(navItem) },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector =if (selected) navItem.selectedIcon else navItem.unselectedIcon ,
                        contentDescription =null,
                        tint = iconColor,
                        modifier = Modifier
                            .size(30.dp)
                            .scale(iconScale)

                    )

                }
            }
        }

    }




}

val navItems= listOf(
    NavItem(
        route =Screen.HomeScreen.route,
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home
    ),
    NavItem(
        route =Screen.ShopScreen.route,
        selectedIcon = Icons.Filled.ShoppingBag,
        unselectedIcon = Icons.Outlined.ShoppingBag
    ),
    NavItem(
        route =Screen.FavScreen.route,
        selectedIcon = Icons.Filled.Sell,
        unselectedIcon = Icons.Outlined.Sell
    ),
    NavItem(
        route =Screen.HomeScreen.route,
        selectedIcon = Icons.Filled.Search,
        unselectedIcon = Icons.Outlined.Search
    )
)


data class NavItem(
    val route:String,
    val selectedIcon:ImageVector,
    val unselectedIcon:ImageVector
)