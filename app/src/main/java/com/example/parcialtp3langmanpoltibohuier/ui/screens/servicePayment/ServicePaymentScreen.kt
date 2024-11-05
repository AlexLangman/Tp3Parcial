package com.example.parcialtp3langmanpoltibohuier.ui.screens.servicePayment

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.parcialtp3langmanpoltibohuier.R
import com.example.parcialtp3langmanpoltibohuier.ui.components.cards.ServiceCard
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconCargarDinero
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconDirectTv
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconExtraerDinero
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconPagoServicio
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconRecargaCelu
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconRecargaSube
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconTransferencia


@Composable
fun ServicePaymentScreen(navController: NavHostController) {
    val services = listOf(
        Pair(getIconRecargaSube(), "RECARGA SUBE"),
        Pair(getIconRecargaCelu(), "RECARGA CELULAR"),
        Pair(getIconPagoServicio(), "PAGO DE SERVICIOS"),
        Pair(getIconDirectTv(), "DIRECT TV PREPAGO"),
    )

    Column(
        modifier = Modifier.fillMaxSize().padding(top = 70.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LazyVerticalGrid (
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)

        ) {
            items(services) { (icon, label) ->
                Card(
                    modifier = Modifier
                        .size(160.dp, 138.dp)
                        .padding(4.dp)
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.outline,
                            shape = RoundedCornerShape(8.dp)
                        ),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(2.dp)
                ){
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            contentAlignment = Alignment.Center
                        ){
                            Image(
                                painter = icon,
                                contentDescription = null,
                                modifier = Modifier.size(32.dp)
                            )
                            Image(
                                painter = painterResource(R.drawable.borde),
                                contentDescription = null,
                                modifier = Modifier.size(64.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(14.dp))
                        Text(
                            text = label,
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 14.4.sp,
                            textAlign = TextAlign.Center // Center text alignment
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ServicePaymentScreenPreview() {
    val navController = rememberNavController()
    ServicePaymentScreen(navController = navController)
}