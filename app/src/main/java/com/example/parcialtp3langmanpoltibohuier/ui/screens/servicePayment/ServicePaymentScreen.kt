package com.example.parcialtp3langmanpoltibohuier.ui.screens.servicePayment

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun ServicePaymentScreen(navController: NavHostController) {
}

@Preview(showBackground = true)
@Composable
fun ServicePaymentScreenPreview() {
    val navController = rememberNavController()
    ServicePaymentScreen(navController = navController)
}