package com.example.parcialtp3langmanpoltibohuier.ui.components.tabBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parcialtp3langmanpoltibohuier.ui.navigation.AppRoutes
import com.example.parcialtp3langmanpoltibohuier.ui.navigation.NavItem
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Green800


@Composable
fun tabBar(navController: NavHostController, currentRoute: String) {
    val items = listOf(
        NavItem.Home,
        NavItem.MyAccount,
        NavItem.MyCard,
        NavItem.ServicePayment,
        NavItem.MyProfile
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .align(Alignment.TopCenter)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .align(Alignment.Center)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                items.forEach { item ->
                    iconTabBar(
                        icon = item.icon,
                        iconSelected = item.iconSelected,
                        label = item.label,
                        isSelected = currentRoute == item.route,
                        onClick = {
                            if (currentRoute != item.route) {
                                navController.navigate(item.route)
                            }
                        }
                    )
                }
            }
        }
    }
}
