package com.example.parcialtp3langmanpoltibohuier.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavItem (
    val route: String,
    val icon: ImageVector,
    val label: String
){
    object Home: NavItem(AppRoutes.HOME, Icons.Default.Home, "Home")
    object MyAccount: NavItem(AppRoutes.MY_ACCOUNT, Icons.Default.Home, "My Account")
    object MyCard: NavItem(AppRoutes.MY_CARD, Icons.Default.Home, "My Card")
    object ServicePayment: NavItem(AppRoutes.SERVICE_PAYMENT, Icons.Default.Home, "Service Payment")
    object MyProfile: NavItem(AppRoutes.SPLASH, Icons.Default.Home, "My Profile")


}
