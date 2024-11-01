package com.example.parcialtp3langmanpoltibohuier.ui.screens.myAccount

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parcialtp3langmanpoltibohuier.ui.components.cards.myAccountCard
import com.example.parcialtp3langmanpoltibohuier.ui.components.cards.transactionCard
import com.example.parcialtp3langmanpoltibohuier.ui.components.dividers.horizontalDivider
import com.example.parcialtp3langmanpoltibohuier.ui.components.samples.sampleTransactions
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Black
import com.example.parcialtp3langmanpoltibohuier.ui.theme.White
import java.time.LocalDate

data class Transaction(
    val date: LocalDate,
    val type: TransactionsType,
    val aut: Int,
    val value : Double,
)

enum class TransactionsType {
    TRANSFERENCIA,
    PAGO_DE_SERVICIO,
    RECARGA_SUBE
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun myAccountScreen() {
    val viewModel: MyAccountViewModel = viewModel()
    //val payments: MutableLiveData<List<Payment>> = viewModel.payments
    val SUBTITLE = "MOVIMIENTOS"

    //viewModel.fetchPayments()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        // Card info de cuenta
        myAccountCard(modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(150.dp))

        // Titulo de franja oscura
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Black)
                .padding(horizontal = 16.dp, vertical = 10.dp),
            contentAlignment = Alignment.TopStart
        ) {
            Text(
                text = SUBTITLE,
                color = White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }

        // Listado de movimientos
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(sampleTransactions) { item ->
                transactionCard(item)
                horizontalDivider()
            }
        }

    }
}

@Preview(showBackground = true)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun myAccountScreenPreview() {
    myAccountScreen()
}