package com.example.parcialtp3langmanpoltibohuier

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.parcialtp3langmanpoltibohuier.ui.navigation.AppRoutes
import com.example.parcialtp3langmanpoltibohuier.ui.screens.Home.HomeRoute
import com.example.parcialtp3langmanpoltibohuier.ui.screens.myAccount.myAccountRoute
import com.example.parcialtp3langmanpoltibohuier.ui.screens.MyCard.MyCardRoute
import com.example.parcialtp3langmanpoltibohuier.ui.screens.ServicePayment.ServicePaymentRoute
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
            myAccountRoute(navController)
        }
        composable(AppRoutes.MY_CARD){
            MyCardRoute(navController)
        }
        composable(AppRoutes.SERVICE_PAYMENT){
            ServicePaymentRoute(navController)
        }
    }
}