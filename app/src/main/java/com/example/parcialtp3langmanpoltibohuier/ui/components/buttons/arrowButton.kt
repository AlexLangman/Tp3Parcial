package com.example.parcialtp3langmanpoltibohuier.ui.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Gray900
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Purple900
import com.example.parcialtp3langmanpoltibohuier.ui.theme.White

@Composable
fun arrowButton(
    text: String,
    description: String?,
    icon: ImageVector,
    iconBackgrounColor: Color,
    isFirst: Boolean = false,
    isLast: Boolean = false,
    isOnlyOne: Boolean = false,
    action: () -> Unit = {

    }
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .border(
                width = 1.dp, // Ancho del borde
                color = Color.Gray, // Color del borde. TODO: Definir color
                shape = when {
                    isFirst -> RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp)
                    isLast -> RoundedCornerShape(bottomStart = 5.dp, bottomEnd = 5.dp)
                    isOnlyOne -> RoundedCornerShape(5.dp)
                    else -> RoundedCornerShape(0.dp)
                } // Borde redondeado
            )
            .padding(5.dp)
            .clickable(onClick = action),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .height(56.dp)
        ) {
            Text(
                text = text,
                color = Purple900, // Cambia el color de la letra a negro
                fontWeight = FontWeight.Bold // Cambia la letra a negrita
            )
            if(description != "" ) {
                description?.let {
                    Text(
                        text = it, // Debe ser un String
                        color = Gray900, // Debe ser un Color
                        fontSize = 10.sp, // Debe ser un TextUnit, que generalmente se especifica como sp
                    )
                }
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