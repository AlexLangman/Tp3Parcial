package com.example.parcialtp3langmanpoltibohuier.ui.screens.splash

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.others.getIconWaynimovil
import com.example.parcialtp3langmanpoltibohuier.ui.navigation.AppRoutes
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Green800
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    var isSplashVisible by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        delay(2000)
        isSplashVisible = false
        navController.navigate(AppRoutes.LOG_IN) {
            popUpTo(AppRoutes.SPLASH) { inclusive = true }
        }
    }

    AnimatedVisibility(
        visible = isSplashVisible,
        enter = fadeIn() + scaleIn(initialScale = 1f),
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(Green800),
            contentAlignment = Alignment.Center,
        ) {
            Row(
                modifier =
                    Modifier
                        .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = getIconWaynimovil(),
                    contentDescription = "Logo",
                    modifier = Modifier.size(257.dp),
                )
            }
        }
    }
}

@Composable
@Preview
fun SplashScreenPreview() {
    SplashScreen(navController = NavHostController(LocalContext.current))
}
