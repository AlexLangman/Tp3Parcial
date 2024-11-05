package com.example.parcialtp3langmanpoltibohuier.ui.theme

import ThemeViewModel
import android.os.Build
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext



private val DarkColorScheme = darkColorScheme(
    primary = Black ,
    background = Gray900,
    outline = Gray100,
    onBackground = White,
)

private val LightColorScheme = lightColorScheme(
    primary = White,
    background = Gray100,
    outline = White,
    onBackground = Black,

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,

    onSurface = Color(0xFF1C1B1F),
    */
)



@Composable
fun ParcialTP3LangmanPoltiBohuierTheme(
    themeViewModel: ThemeViewModel = viewModel(), // Añade el ViewModel como parámetro por defecto
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val isDarkTheme by themeViewModel.isDarkTheme.observeAsState(false) // Observa el estado del tema

    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (isDarkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        isDarkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = CustomTypography,
        content = content
    )
}
