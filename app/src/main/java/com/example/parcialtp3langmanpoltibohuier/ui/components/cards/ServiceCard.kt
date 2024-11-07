package com.example.parcialtp3langmanpoltibohuier.ui.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconCargarDinero

@Composable
fun ServiceCard(
    icon: Painter,
    label: String,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier.size(112.dp, 96.dp).clickable(onClick = onClick),
        colors =
            CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
        elevation = CardDefaults.cardElevation(0.dp),
    ) {
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(top = 5.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // Centered Image
            Image(
                painter = icon,
                contentDescription = null,
                modifier = Modifier.size(24.dp),
            )
            // Bottom Text
            Text(
                text = label,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold,
                lineHeight = 14.4.sp,
                modifier =
                    Modifier
                        .size(84.dp, 38.dp)
                        .padding(vertical = 4.dp),
                textAlign = TextAlign.Center, // Center text alignment
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ServiceCardPreview() {
    MaterialTheme {
        ServiceCard(
            icon = getIconCargarDinero(),
            label = "CARGAR DINERO",
            onClick = {},
        )
    }
}
