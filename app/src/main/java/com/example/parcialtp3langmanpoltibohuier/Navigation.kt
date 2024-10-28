package com.example.parcialtp3langmanpoltibohuier

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

//https://www.youtube.com/watch?v=4gUeyNkGE3g
@Composable()
fun Navigation(paddingValues: PaddingValues,navController: NavHostController){

    NavHost(navController = navController, startDestination = ""){
        //composable(route = Screen.LoginScreen.route){ LoginPage(navController = navController, paddingValues = paddingValues)}
    }
}