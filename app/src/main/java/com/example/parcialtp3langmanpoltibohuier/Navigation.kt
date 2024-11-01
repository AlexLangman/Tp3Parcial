package com.example.parcialtp3langmanpoltibohuier

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.parcialtp3langmanpoltibohuier.ui.components.tabBar.tabBar
import com.example.parcialtp3langmanpoltibohuier.ui.navigation.AppRoutes
import com.example.parcialtp3langmanpoltibohuier.ui.screens.Home.HomeRoute
import com.example.parcialtp3langmanpoltibohuier.ui.screens.MyAccount.MyAccountRoute
import com.example.parcialtp3langmanpoltibohuier.ui.screens.MyCard.MyCardRoute
import com.example.parcialtp3langmanpoltibohuier.ui.screens.ServicePayment.ServicePaymentRoute
import com.example.parcialtp3langmanpoltibohuier.ui.screens.SignIn.SignInRoute
import com.example.parcialtp3langmanpoltibohuier.ui.screens.Splash.SplashRoute


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable()
fun Navigation(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: AppRoutes.HOME


    Scaffold(

        topBar = {
        },
        bottomBar = {
            if(currentRoute != AppRoutes.SPLASH && currentRoute != AppRoutes.SIGN_IN ){
                tabBar(navController = navController, currentRoute = currentRoute )
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = AppRoutes.HOME
        )
        {
            composable(AppRoutes.SPLASH) {
                SplashRoute(navController)
            }
            composable(AppRoutes.SIGN_IN) {
                SignInRoute(navController)
            }
            composable(AppRoutes.HOME) {
                HomeRoute(navController)
            }
            composable(AppRoutes.MY_ACCOUNT) {
                MyAccountRoute(navController)
            }
            composable(AppRoutes.MY_CARD) {
                MyCardRoute(navController)
            }
            composable(AppRoutes.SERVICE_PAYMENT) {
                ServicePaymentRoute(navController)
            }
        }
    }
}