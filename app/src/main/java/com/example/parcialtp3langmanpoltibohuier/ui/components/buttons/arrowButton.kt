package com.example.parcialtp3langmanpoltibohuier.ui.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun arrowButton(
    text: String,
    icon: ImageVector,
    iconBackgrounColor: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text,
            color = Color.Black, // Cambia el color de la letra a negro
            fontWeight = FontWeight.Bold // Cambia la letra a negrita
        )
        Box(
            modifier = Modifier
                .size(40.dp) // Tamaño del círculo
                .clip(CircleShape) // Forma circular
                .background(iconBackgrounColor), // Fondo verde
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.White, // Cambia el color del ícono a blanco
                modifier = Modifier.size(24.dp) // Tamaño del ícono dentro del círculo
            )
        }
    }
}