package com.example.parcialtp3langmanpoltibohuier.ui.screens.myAccount

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parcialtp3langmanpoltibohuier.dataClasses.Transaction
import com.example.parcialtp3langmanpoltibohuier.ui.components.cards.MyAccountCard
import com.example.parcialtp3langmanpoltibohuier.ui.components.cards.ServiceCard
import com.example.parcialtp3langmanpoltibohuier.ui.components.cards.TransactionCard
import com.example.parcialtp3langmanpoltibohuier.ui.components.dividers.CustomHorizontalDivider
import com.example.parcialtp3langmanpoltibohuier.ui.components.dividers.CustomVerticalDivider
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconCargarDinero
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconExtraerDinero
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconTransferencia

const val SUBTITLE = "MOVIMIENTOS"
const val LOADING = "Cargando transacciones..."

@Composable
fun MyAccountScreen() {
    val viewModel: MyAccountViewModel = viewModel()
    val payments by viewModel.payments.observeAsState(emptyList())

    // Llama a fetchPayments() una vez cuando el Composable se lanza
    LaunchedEffect(Unit) {
        viewModel.fetchPayments()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MyAccountCard()
        Spacer(modifier = Modifier.height(28.dp))
        MenuIntermedio()
        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.onBackground)
                    .padding(horizontal = 16.dp, vertical = 10.dp),
            contentAlignment = Alignment.TopStart,
        ) {
            Text(
                text = SUBTITLE,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
            )
        }

        if (payments != null && payments!!.isNotEmpty()) {
            LazyColumn(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .background(color = MaterialTheme.colorScheme.primary),
            ) {
                val transactions: List<Transaction> =
                    payments!![0].transactions.credit_card_transactions +
                        payments!![0].transactions.bank_account_transactions

                items(transactions) { item ->
                    TransactionCard(item)
                    CustomHorizontalDivider()
                }
            }
        } else {
            Text(text = LOADING)
        }
    }
}

@Composable
fun MenuIntermedio() {
    Card(
        modifier =
            Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline,
                    shape = RoundedCornerShape(8.dp),
                ).shadow(3.dp, RoundedCornerShape(8.dp)),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(4.dp),
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                ServiceCard(icon = getIconCargarDinero(), label = "CARGAR DINERO", onClick = {})
                CustomVerticalDivider()
                ServiceCard(icon = getIconExtraerDinero(), label = "EXTRAER DINERO", onClick = {})
                CustomVerticalDivider()
                ServiceCard(
                    icon = getIconTransferencia(),
                    label = "TRANSFERIR DINERO",
                    onClick = {},
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyAccountScreenPreview() {
    MyAccountScreen()
}
