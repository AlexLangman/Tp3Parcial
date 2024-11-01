package com.example.parcialtp3langmanpoltibohuier.ui.components.cards

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcialtp3langmanpoltibohuier.ui.screens.myAccount.Transaction
import com.example.parcialtp3langmanpoltibohuier.ui.screens.myAccount.TransactionsType
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Green1
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Red1
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
val dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yy")

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun transactionCard(transaction: Transaction) {
    Box(modifier = Modifier.padding(8.dp)){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top,
        ) {
            // Fecha
            Text(
                text = transaction.date.format(dateFormatter),
                modifier = Modifier.padding(start= 6.dp, end = 20.dp),
                fontSize = 15.sp
            )

            // Descripción
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = transaction.type.toString(),
                    fontSize = 15.sp
                )
                Text(
                    text = "Aut. " + transaction.aut.toString(),
                    fontSize = 15.sp
                )
            }

            // Valor
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ){
                if(transaction.value >= 0) {
                    Text(
                        text = formattedValue(transaction.value),
                        fontWeight = FontWeight.Medium,
                        fontSize = 15.sp,
                        color = Green1
                    )
                } else {
                    Text(
                        text = formattedValue(transaction.value),
                        fontWeight = FontWeight.Medium,
                        fontSize = 15.sp,
                        color = Red1
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
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun transactionCardPreview() {
    val transaction = Transaction(
        LocalDate.of(2020,3,19),
        TransactionsType.TRANSFERENCIA,
        394991,
        2000.00)
    transactionCard(transaction)
}