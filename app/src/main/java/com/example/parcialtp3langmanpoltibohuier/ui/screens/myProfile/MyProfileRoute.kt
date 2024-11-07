package com.example.parcialtp3langmanpoltibohuier.ui.screens.myProfile

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.parcialtp3langmanpoltibohuier.MainViewModel
import kotlinx.coroutines.CoroutineScope

@Composable
fun MyProfileRoutes(
    navController: NavHostController,
    mainViewModel: MainViewModel,
    coroutineScope: CoroutineScope,
) {
    MyProfileScreen(navController = navController, mainViewModel, coroutineScope)
}
