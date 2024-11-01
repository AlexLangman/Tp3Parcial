package com.example.parcialtp3langmanpoltibohuier.ui.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.sp
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Gray1
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Purple1
import com.example.parcialtp3langmanpoltibohuier.ui.theme.White

@Composable
fun arrowButton(
    text: String,
    description: String?,
    icon: ImageVector,
    iconBackgrounColor: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .border(
                width = 1.dp, // Ancho del borde
                color = Color.Gray, // Color del borde
                shape = RoundedCornerShape(5.dp) // Borde redondeado
            )
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = text,
                color = Purple1, // Cambia el color de la letra a negro
                fontWeight = FontWeight.Bold // Cambia la letra a negrita
            )
            description?.let {
                Text(
                    text = it, // Debe ser un String
                    color = Gray1, // Debe ser un Color
                    fontSize = 10.sp, // Debe ser un TextUnit, que generalmente se especifica como sp
                )
            }
        }
        Box(
            modifier = Modifier
                .size(20.dp) // Tamaño del círculo
                .clip(CircleShape) // Forma circular
                .background(iconBackgrounColor), // Fondo verde
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = White, // Cambia el color del ícono a blanco
                modifier = Modifier.size(24.dp) // Tamaño del ícono dentro del círculo
            )
        }
    }
}