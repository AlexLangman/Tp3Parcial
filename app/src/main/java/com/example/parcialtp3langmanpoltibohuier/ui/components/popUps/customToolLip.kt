package com.example.parcialtp3langmanpoltibohuier.ui.components.popUps

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun Tooltip(
    text: String,
    isVisible: Boolean,
    onDismiss: () -> Unit
) {
    if (isVisible) {
        Box(
            modifier = Modifier
                .padding(top = 8.dp)
                .background(Color.Gray, shape = RoundedCornerShape(4.dp))
                .padding(8.dp)
                .offset(y = (-50).dp)
        ) {
            Text(text)
        }

        // Ocultar el Tooltip después de un tiempo
        LaunchedEffect(Unit) {
            delay(2000) // Cambia la duración según sea necesario
            onDismiss() // Llama a la función para ocultar el tooltip
        }
    }
}