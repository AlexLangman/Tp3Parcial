package com.example.parcialtp3langmanpoltibohuier.ui.components.dividers

import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Gray500

@Composable
fun CustomHorizontalDivider() {
    HorizontalDivider(
        thickness = 1.dp,
        modifier = Modifier.height(8.dp),
        color = Gray500
    )
}