package com.example.parcialtp3langmanpoltibohuier.ui.components.dividers

import androidx.compose.foundation.layout.height
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Gray500

@Composable
fun CustomVerticalDivider() {
    VerticalDivider(
        thickness = 1.dp,
        modifier = Modifier.height(96.dp),
        color = Gray500,
    )
}
