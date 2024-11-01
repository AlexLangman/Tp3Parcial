package com.example.parcialtp3langmanpoltibohuier.ui.components.tabBar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Green2
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Purple1


@Composable
fun iconTabBar(icon: ImageVector, label: String, isSelected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clickable(onClick = onClick) // Hace que todo el área del Box sea clickeable
            .then(
                if (isSelected) Modifier.border(BorderStroke(2.dp, Green2), shape = RectangleShape)
                else Modifier
            )
            .padding(top = 4.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = if (isSelected) Green2 else Purple1,
        )
    }
}