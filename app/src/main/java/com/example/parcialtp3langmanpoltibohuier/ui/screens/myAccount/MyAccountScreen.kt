package com.example.parcialtp3langmanpoltibohuier.ui.screens.myAccount

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parcialtp3langmanpoltibohuier.ui.components.cards.MyAccountCard
import com.example.parcialtp3langmanpoltibohuier.ui.components.cards.TransactionCard
import com.example.parcialtp3langmanpoltibohuier.ui.components.dividers.horizontalDivider
import com.example.parcialtp3langmanpoltibohuier.ui.components.samples.sampleTransactions
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Black
import com.example.parcialtp3langmanpoltibohuier.ui.theme.White
import androidx.compose.runtime.livedata.observeAsState
import com.example.parcialtp3langmanpoltibohuier.dataClasses.Transaction
import com.example.parcialtp3langmanpoltibohuier.ui.components.cards.ServiceCard
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconCargarDinero
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconExtraerDinero
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconPagoServicio
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconPrestamos
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconRecargaCelu
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconRecargaSube
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconTransferencia
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Gray500


@Composable
fun MyAccountScreen() {
    //val viewModel: MyAccountViewModel = viewModel()
    //val payments by viewModel.payments.observeAsState(emptyList())
    val SUBTITLE = "MOVIMIENTOS"
    val LOADING = "Cargando transacciones..."

    // Llama a fetchPayments() una vez cuando el Composable se lanza
    /*LaunchedEffect(Unit) {
        viewModel.fetchPayments()
    }*/

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        MyAccountCard()
        Spacer(modifier = Modifier.height(8.dp))
        MenuIntermedio()
        Spacer(modifier = Modifier.height(8.dp))

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

        //if (payments != null && payments!!.isNotEmpty()){
            // Listado de movimientos
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                /*val transactions: List<Transaction> =
                    payments!![0].transactions.credit_card_transactions +
                            payments!![0].transactions.bank_account_transactions
                            
                 */
                val transactions = sampleTransactions
                items(transactions) { item ->
                    TransactionCard(item)
                    horizontalDivider()
                }
            }
        /*}
        else {
            Text(text = LOADING)
        }*/
    }
}

@Composable
fun MenuIntermedio() {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .padding(bottom = 16.dp)
            .border(
                width = 1.dp,
                color = Gray500,
                shape = RoundedCornerShape(8.dp)
            ),
        colors = CardDefaults.cardColors(containerColor = White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically

            ) {
                ServiceCard(icon = getIconCargarDinero(), label = "CARGAR DINERO")
                VerticalDivider(thickness = 1.dp, modifier = Modifier.height(96.dp))
                ServiceCard(icon = getIconExtraerDinero(), label = "EXTRAER DINERO")
                VerticalDivider(thickness = 1.dp, modifier = Modifier.height(96.dp))
                ServiceCard(icon = getIconTransferencia(), label = "TRANSFERIR DINERO")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyAccountScreenPreview() {
    MyAccountScreen()
}