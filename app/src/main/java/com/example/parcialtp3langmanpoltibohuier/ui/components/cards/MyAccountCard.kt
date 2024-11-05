package com.example.parcialtp3langmanpoltibohuier.ui.components.cards

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Black
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Gray500
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Purple900
import com.example.parcialtp3langmanpoltibohuier.ui.theme.White

@Composable
fun MyAccountCard() {
    // Especificaciones generales
    val GAP = 16.dp
    val PADDING = 24.dp
    val BORDER_WIDTH = 1.dp
    val BORDER_COLOR = Gray500
    val BORDER_RADIUS = 8.dp
    val CARD_ELEVATION = 4.dp
    val CARD_BACKGROUND_COLOR = White

    // Textos
    val TXT_GAP = 16.dp
    val BALANCE_TITLE = "SALDO DISPONIBLE"
    var balance = "$1.322,78" // TODO: Importar info del back


    Card(
        modifier = Modifier
            .sizeIn(minWidth = 336.dp, minHeight = 153.dp)
            .padding(horizontal = GAP, vertical = PADDING)
            .border(
                width = BORDER_WIDTH,
                color = BORDER_COLOR,
                shape = RoundedCornerShape(BORDER_RADIUS)
            ),
        colors = CardDefaults.cardColors(containerColor = CARD_BACKGROUND_COLOR),
        elevation = CardDefaults.cardElevation(CARD_ELEVATION)
    ) {
        Column(
            modifier = Modifier.padding(PADDING),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = BALANCE_TITLE,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Black
            )
            Text(
                text = balance,
                modifier = Modifier.padding(bottom = TXT_GAP),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Black
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
                    color = Black
                )
                Text(
                    modifier = Modifier.padding(end = TXT_GAP),
                    text = "0000654326538129540653", // TODO: Importar info del back
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Black
                )
                Text(
                    text = "Copiar", // TODO: dar funcionalidad de Copy
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Purple900)
            }
        }
    }
}


@Preview
@Composable
fun MyAccountCardPreview() {
    MyAccountCard()
}