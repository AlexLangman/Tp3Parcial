package com.example.parcialtp3langmanpoltibohuier.ui.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcialtp3langmanpoltibohuier.dataClasses.Transaction
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Green900
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Red900

@Composable
fun TransactionCard(transaction: Transaction) {
    Box(
        modifier = Modifier.padding(8.dp).background(color = MaterialTheme.colorScheme.primary),
    ) {
        Row(
            modifier =
                Modifier
                    .fillMaxWidth(),
            verticalAlignment = Alignment.Top,
        ) {
            // Fecha
            Text(
                text = transaction.date,
                modifier = Modifier.padding(start = 6.dp, end = 24.dp),
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
            )

            // Descripción
            Column(
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = transaction.type,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                )
                Text(
                    text = "Aut. " + transaction.transaction_id,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                )
            }

            // Valor
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
            ) {
                if (transaction.amount >= 0) {
                    Text(
                        text = formattedValue(transaction.amount),
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = Green900,
                    )
                } else {
                    Text(
                        text = formattedValue(transaction.amount),
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = Red900,
                    )
                }
            }
        }
    }
}

fun formattedValue(value: Double): String {
    val formattedValue = String.format("%.2f", Math.abs(value)).replace('.', ',')
    return if (value >= 0) {
        "+$$formattedValue"
    } else {
        "-$$formattedValue"
    }
}

@Preview(showBackground = true)
@Composable
fun TransactionCardPreview() {
    val transaction =
        Transaction(
            "394991",
            "19-03-20",
            "Transferencia",
            2000.00,
            "$",
            "Transferencia",
        )
    TransactionCard(transaction)
}
