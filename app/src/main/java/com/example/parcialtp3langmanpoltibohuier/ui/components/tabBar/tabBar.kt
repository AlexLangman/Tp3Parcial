package com.example.parcialtp3langmanpoltibohuier.ui.components.tabBar

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.parcialtp3langmanpoltibohuier.ui.navigation.AppRoutes
import com.example.parcialtp3langmanpoltibohuier.ui.navigation.NavItem


@Composable
fun tabBar(navController: NavHostController, currentRoute: String) {
    val items = listOf(
        NavItem.Home,
        NavItem.MyAccount,
        NavItem.MyCard,
        NavItem.ServicePayment,
        NavItem.MyProfile
    )

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    iconTabBar(
                        icon = item.icon,
                        label = item.label,
                        isSelected = currentRoute == item.route) {

                    }
                },
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route)
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                )
            )
        }
    }
}

