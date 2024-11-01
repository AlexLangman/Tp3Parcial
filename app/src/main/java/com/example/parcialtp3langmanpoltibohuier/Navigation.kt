package com.example.parcialtp3langmanpoltibohuier

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.parcialtp3langmanpoltibohuier.ui.navigation.AppRoutes
import com.example.parcialtp3langmanpoltibohuier.ui.screens.home.HomeRoute
import com.example.parcialtp3langmanpoltibohuier.ui.screens.MyAccount.MyAccountRoute
import com.example.parcialtp3langmanpoltibohuier.ui.screens.MyCard.MyCardRoute
import com.example.parcialtp3langmanpoltibohuier.ui.screens.servicePayment.ServicePaymentRoute
import com.example.parcialtp3langmanpoltibohuier.ui.screens.SignIn.SignInRoute
import com.example.parcialtp3langmanpoltibohuier.ui.screens.Splash.SplashRoute


@Composable()
fun Navigation(navController: NavHostController){

    NavHost(
        navController = navController,
        startDestination = AppRoutes.SPLASH)
    {
        composable(AppRoutes.SPLASH){
            SplashRoute(navController)
        }
        composable(AppRoutes.SIGN_IN){
            SignInRoute(navController)
        }
        composable(AppRoutes.HOME){
            HomeRoute(navController)
        }
        composable(AppRoutes.MY_ACCOUNT){
            MyAccountRoute(navController)
        }
        composable(AppRoutes.MY_CARD){
            MyCardRoute(navController)
        }
        composable(AppRoutes.SERVICE_PAYMENT){
            ServicePaymentRoute(navController)
        }
    }
}