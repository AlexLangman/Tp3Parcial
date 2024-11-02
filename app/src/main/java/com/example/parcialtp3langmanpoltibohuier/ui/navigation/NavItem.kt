package com.example.parcialtp3langmanpoltibohuier.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.tabBar.getIconHome
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.tabBar.getIconHomeSelected
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.tabBar.getIconMenu
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.tabBar.getIconMenuSelected
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.tabBar.getIconMovement
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.tabBar.getIconMovementSelected
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.tabBar.getIconWalet
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.tabBar.getIconWaletSelected

sealed class NavItem(
    val route: String,
    val icon: @Composable () -> Painter,
    val iconSelected: @Composable () -> Painter,
    val label: String
){
    object Home: NavItem(AppRoutes.HOME, {getIconHome()}, {getIconHomeSelected()}, "Home")
    object MyAccount: NavItem(AppRoutes.MY_ACCOUNT, { getIconMovement() }, { getIconMovementSelected()}, "My Account")
    object MyCard: NavItem(AppRoutes.MY_CARD, { getIconWalet()},{ getIconWaletSelected() }, "My Card")
    object ServicePayment: NavItem(AppRoutes.SERVICE_PAYMENT, { getIconMovement()},{ getIconMovementSelected()}, "Service Payment")
    object MyProfile: NavItem(AppRoutes.MY_PROFILE, { getIconMenu()}, { getIconMenuSelected()}, "My Profile")


}
