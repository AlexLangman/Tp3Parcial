package com.example.parcialtp3langmanpoltibohuier.ui.components.cards

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// General Constants
private const val BALANCE_TITLE = "SALDO DISPONIBLE"
private const val BALANCE_AMOUNT = "$1.322,78"
private const val CVU_NUMBER = "0000654326538129540653"
private const val COPY_LABEL = "Copiar"

// Styling Constants
private val GAP = 16.dp
private val PADDING = 24.dp
private val BORDER_WIDTH = 1.dp
private val BORDER_RADIUS = 8.dp
private val CARD_ELEVATION = 4.dp
private val TXT_GAP = 16.dp

@Composable
fun MyAccountCard() {
    Card(
        modifier =
            Modifier
                .sizeIn(minWidth = 336.dp, minHeight = 153.dp)
                .padding(horizontal = GAP)
                .border(
                    width = BORDER_WIDTH,
                    color = MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(BORDER_RADIUS),
                ).shadow(3.dp, RoundedCornerShape(BORDER_RADIUS)),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(CARD_ELEVATION),
    ) {
        Column(
            modifier = Modifier.padding(PADDING),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = BALANCE_TITLE,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
            )
            Text(
                text = BALANCE_AMOUNT,
                modifier = Modifier.padding(bottom = TXT_GAP),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
            )

            HorizontalDivider(modifier = Modifier.padding(horizontal = GAP))

            Row(
                modifier = Modifier.padding(top = TXT_GAP),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                Text(
                    text = "CVU: ",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onBackground,
                )
                Text(
                    modifier = Modifier.padding(end = TXT_GAP),
                    text = CVU_NUMBER,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground,
                )
                Text(
                    text = COPY_LABEL,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground,
                )
            }
        }
    }
}

@Preview
@Composable
fun MyAccountCardPreview() {
    MyAccountCard()
}
