package com.example.parcialtp3langmanpoltibohuier.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.parcialtp3langmanpoltibohuier.R

val manropeFontFamily = FontFamily(
        Font(R.font.manropebold, FontWeight.Bold),
        Font(R.font.manropemedium, FontWeight.Medium),
        Font(R.font.manroperegular, FontWeight.Normal),
    )

val CustomTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = manropeFontFamily,
        fontSize = 74.sp,
        fontWeight = FontWeight.W700,
        lineHeight = 74.sp,
        letterSpacing = (-0.02).em,
        // XL6
        ),
    displayMedium = TextStyle(
        fontFamily = manropeFontFamily,
        fontSize = 44.sp,
        fontWeight = FontWeight.W700,
        lineHeight = 48.4.sp,
        letterSpacing = (-0.01).em,
        // XL5
        ),
    displaySmall = TextStyle(
        fontFamily = manropeFontFamily,
        fontSize = 32.sp,
        fontWeight = FontWeight.W700,
        lineHeight = 35.2.sp,
        // XL4
        ),
    headlineLarge = TextStyle(
        fontFamily = manropeFontFamily,
        fontSize = 24.sp,
        fontWeight = FontWeight.W700,
        lineHeight = 26.4.sp,
        // XL3 Bold
        ),
    headlineMedium = TextStyle(
        fontFamily = manropeFontFamily,
        fontSize = 24.sp,
        fontWeight = FontWeight.W500,
        lineHeight = 26.4.sp,
        // XL3 Regular
        ),
    headlineSmall = TextStyle(
        fontFamily = manropeFontFamily,
        fontSize = 20.sp,
        fontWeight = FontWeight.W700,
        lineHeight = 24.sp,
        // XL2 Bold
        ),
    titleLarge = TextStyle(
        fontFamily = manropeFontFamily,
        fontSize = 20.sp,
        fontWeight = FontWeight.W500,
        lineHeight = 24.sp,
        // XL2 Regular
    ),
    titleMedium = TextStyle(
        fontFamily = manropeFontFamily,
        fontSize = 18.sp,
        fontWeight = FontWeight.W700,
        lineHeight = 21.6.sp,
        // XL1 Bold Mobile
    ),
    titleSmall = TextStyle(
        fontFamily = manropeFontFamily,
        fontSize = 18.sp,
        fontWeight = FontWeight.W500,
        lineHeight = 21.6.sp,
        // XL1 Regular Mobile
    ),
    bodyLarge =
    TextStyle(
        fontFamily = manropeFontFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.W700,
        lineHeight = 22.4.sp,
        // Base Bold
    ),
    bodyMedium =
    TextStyle(
        fontFamily = manropeFontFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.W500,
        lineHeight = 22.4.sp,
        // Base Regular
    ),
    bodySmall =
    TextStyle(
        fontFamily = manropeFontFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.W700,
        lineHeight = 19.6.sp,
        // XS1 Bold
    ),
    labelLarge =
    TextStyle(
        fontFamily = manropeFontFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.W500,
        lineHeight = 19.6.sp,
        // XS1 Regular
    ),
    labelMedium =
    TextStyle(
        fontFamily = manropeFontFamily,
        fontSize = 12.sp,
        fontWeight = FontWeight.W700,
        lineHeight = 14.4.sp,
        // XS2 Bold
    ),
    labelSmall =
    TextStyle(
        fontFamily = manropeFontFamily,
        fontSize = 12.sp,
        fontWeight = FontWeight.W500,
        lineHeight = 14.4.sp,
        // XS2 Regular
    ),
)
