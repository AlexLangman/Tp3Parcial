package com.example.parcialtp3langmanpoltibohuier

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.parcialtp3langmanpoltibohuier.ui.components.tabBar.tabBar
import com.example.parcialtp3langmanpoltibohuier.ui.components.topBar.topBarCustom
import com.example.parcialtp3langmanpoltibohuier.ui.navigation.AppRoutes
import com.example.parcialtp3langmanpoltibohuier.ui.screens.home.HomeRoute
import com.example.parcialtp3langmanpoltibohuier.ui.screens.myCard.MyCardRoute
import com.example.parcialtp3langmanpoltibohuier.ui.screens.servicePayment.ServicePaymentRoute
import com.example.parcialtp3langmanpoltibohuier.ui.screens.SignIn.SignInRoute
import com.example.parcialtp3langmanpoltibohuier.ui.screens.Splash.SplashRoute
import com.example.parcialtp3langmanpoltibohuier.ui.screens.myAccount.myAccountRoute


@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable()
fun Navigation(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: AppRoutes.HOME


    Scaffold(
        topBar = {
            if(currentRoute != AppRoutes.SPLASH && currentRoute != AppRoutes.SIGN_IN){
                topBarCustom(currentRoute)
            }
        },
        bottomBar = {
            if (currentRoute != AppRoutes.SPLASH && currentRoute != AppRoutes.SIGN_IN) {
                tabBar(navController = navController, currentRoute = currentRoute)
            }
        },
        modifier = Modifier.windowInsetsPadding(WindowInsets.systemBars)
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppRoutes.HOME,
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
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
                myAccountRoute(navController)
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