package com.example.parcialtp3langmanpoltibohuier

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.parcialtp3langmanpoltibohuier.ui.navigation.AppRoutes
import com.example.parcialtp3langmanpoltibohuier.ui.screens.home.HomeRoute
import com.example.parcialtp3langmanpoltibohuier.ui.screens.logIn.LogInRoute
import com.example.parcialtp3langmanpoltibohuier.ui.screens.myAccount.MyAccountRoute
import com.example.parcialtp3langmanpoltibohuier.ui.screens.myCard.MyCardRoute
import com.example.parcialtp3langmanpoltibohuier.ui.screens.myProfile.MyProfileRoutes
import com.example.parcialtp3langmanpoltibohuier.ui.screens.servicePayment.ServicePaymentRoute
import com.example.parcialtp3langmanpoltibohuier.ui.screens.splash.SplashRoute
import kotlinx.coroutines.CoroutineScope

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Navigation(
    navController: NavHostController,
    mainViewModel: MainViewModel,
    coroutineScope: CoroutineScope,
) {
    NavHost(
        navController = navController,
        startDestination = AppRoutes.SPLASH,
        modifier =
            Modifier
                .fillMaxSize(),
    ) {
        composable(AppRoutes.SPLASH) {
            SplashRoute(navController)
        }
        composable(AppRoutes.LOG_IN) {
            LogInRoute(navController)
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
        composable(AppRoutes.MY_PROFILE) {
            MyProfileRoutes(navController, mainViewModel, coroutineScope)
        }
    }
}
