package com.example.parcialtp3langmanpoltibohuier.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.parcialtp3langmanpoltibohuier.R

val manropeFontFamily =
    FontFamily(
        Font(R.font.manropebold, FontWeight.Bold),
        Font(R.font.manropemedium, FontWeight.Medium),
        Font(R.font.manroperegular, FontWeight.Normal),
    )

val CustomTypography =
    Typography(
        displayLarge =
            TextStyle(
                fontFamily = manropeFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 74.sp,
                lineHeight = 74.sp,
                letterSpacing = (-0.02).em,
                // XL6
            ),
        displayMedium =
            TextStyle(
                fontFamily = manropeFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 44.sp,
                lineHeight = 48.4.sp,
                letterSpacing = (-0.01).em,
                // Xl5
            ),
        displaySmall =
            TextStyle(
                fontFamily = manropeFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 32.sp,
                lineHeight = 35.2.sp,
                // XL4
            ),
        headlineLarge =
            TextStyle(
                fontFamily = manropeFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                lineHeight = 26.4.sp,
                // XL3
            ),
        headlineMedium =
            TextStyle(
                fontFamily = manropeFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                lineHeight = 24.sp,
            ),
        headlineSmall =
            TextStyle(
                fontFamily = manropeFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                lineHeight = 21.6.sp,
            ),
        bodyLarge =
            TextStyle(
                fontFamily = manropeFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 22.4.sp,
            ),
        bodyMedium =
            TextStyle(
                fontFamily = manropeFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                lineHeight = 19.6.sp,
            ),
        bodySmall =
            TextStyle(
                fontFamily = manropeFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                lineHeight = 14.4.sp,
            ),
        labelLarge =
            TextStyle(
                fontFamily = manropeFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                lineHeight = 19.6.sp,
            ),
        labelMedium =
            TextStyle(
                fontFamily = manropeFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                lineHeight = 14.4.sp,
            ),
        labelSmall =
            TextStyle(
                fontFamily = manropeFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 10.sp,
                lineHeight = 12.sp,
            ),
    )
