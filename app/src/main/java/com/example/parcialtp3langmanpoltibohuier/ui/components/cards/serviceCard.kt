package com.example.parcialtp3langmanpoltibohuier.ui.components.cards

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Train
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ServiceCard(
    icon: ImageVector,
    label: String
) {
    Card(
        modifier = Modifier
            .size(100.dp)
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Centered Icon
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(32.dp)
            )
            // Bottom Text

                Text(
                    text = label,
                    fontSize = 10.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Light,
                    lineHeight = 12.sp,
                    modifier = Modifier
                        .fillMaxWidth() // Make the text take the full width
                        .padding(top = 4.dp), // Optional padding between icon and text
                    textAlign = TextAlign.Center // Center text alignment
                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ServiceCardPreview() {
    MaterialTheme {
        ServiceCard(
            icon = Icons.Filled.Train, // Using a built-in Material icon
            label = "CARGAR DINERO"
        )
    }
}
