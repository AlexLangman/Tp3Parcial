package com.example.parcialtp3langmanpoltibohuier.ui.components.dividers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun horizontalDivider() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        HorizontalDivider(thickness = 1.dp)
    }
}