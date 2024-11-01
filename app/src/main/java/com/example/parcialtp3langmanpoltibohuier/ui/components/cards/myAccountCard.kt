package com.example.parcialtp3langmanpoltibohuier.ui.components.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Purple1
import com.example.parcialtp3langmanpoltibohuier.ui.theme.White

@Composable
fun myAccountCard(modifier: Modifier) {
    val SEPARATION_SIZE = 8.dp

    Card(
        modifier = Modifier
            .size(500.dp, 175.dp)
            .padding(SEPARATION_SIZE),
        colors = CardDefaults.cardColors(containerColor = White),
        elevation = CardDefaults.cardElevation(defaultElevation = SEPARATION_SIZE)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(SEPARATION_SIZE),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "SALDO DISPONIBLE",
                modifier = Modifier
                    .padding(bottom = 2.dp),
                fontWeight = FontWeight.Medium
            )
            Text(
                text = "$1.322,78",
                modifier = Modifier
                    .padding(bottom = SEPARATION_SIZE),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            ) // TODO: Verificar si se mantiene esto

            HorizontalDivider(modifier = Modifier.padding(horizontal = SEPARATION_SIZE * 2))

            Row(
                modifier = Modifier
                    .padding(top = SEPARATION_SIZE * 2),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                Text(
                    text = "CVU: ",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    modifier = Modifier
                        .padding(start = SEPARATION_SIZE, end = SEPARATION_SIZE * 2),
                    text = "0000654326538129540653",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "Copiar",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Purple1)
            }
        }
    }
}


@Preview
@Composable
fun myAccountCardPreview() {
    myAccountCard(modifier = Modifier)
}