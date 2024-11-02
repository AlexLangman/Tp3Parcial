package com.example.parcialtp3langmanpoltibohuier.ui.screens.myAccount

import android.os.Build
import android.util.Log
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
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
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Black
import com.example.parcialtp3langmanpoltibohuier.ui.theme.White
import androidx.compose.runtime.livedata.observeAsState
import com.example.parcialtp3langmanpoltibohuier.dataClasses.Transaction


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun myAccountScreen() {
    val viewModel: MyAccountViewModel = viewModel()
    val payments by viewModel.payments.observeAsState(emptyList())
    val SUBTITLE = "MOVIMIENTOS"
    val LOADING = "Cargando transacciones..."

    // Llama a fetchPayments() una vez cuando el Composable se lanza
    LaunchedEffect(Unit) {
        viewModel.fetchPayments()
    }

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

        if (payments != null && payments!!.isNotEmpty()){
            // Listado de movimientos
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                val transacctions: List<Transaction> = payments!![0].transactions.credit_card_transactions + payments!![0].transactions.bank_account_transactions
                items(transacctions) { item ->
                    transactionCard(item)
                    horizontalDivider()
                }
            }
        }
        else {
            Text(text = LOADING)
        }
    }
}

@Preview(showBackground = true)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun myAccountScreenPreview() {
    myAccountScreen()
}