package com.example.parcialtp3langmanpoltibohuier.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.parcialtp3langmanpoltibohuier.ui.components.cards.GetCreditCard
import com.example.parcialtp3langmanpoltibohuier.ui.components.cards.ServiceCard
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconCargarDinero
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconExtraerDinero
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconPagoServicio
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconPrestamos
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconRecargaCelu
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconRecargaSube

@Composable
fun HomeScreen(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Greeting
        item {
            Text(
                text = "👋 Hola Mariana",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
        }

        item {
            Text(
                text = "Último acceso: Mar 01, 2020 4:55 PM",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray, // TODO: change color
                modifier = Modifier.fillMaxWidth()
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            GetCreditCard(cardNumber = "4957 **** **** 5824", expirationDate = "05/23")
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Balance and Actions
        item {
            TextButton(onClick = { /* TODO: Show more card details */ }) {
                Text(text = "Mostrar datos", color = MaterialTheme.colorScheme.primary)
            }
        }

        item {
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            Text(
                text = "SALDO DISPONIBLE",
                style = MaterialTheme.typography.labelMedium,
                color = Color.Gray // TODO: change color
            )
        }

        item {
            Text(
                text = "$1.322,78",
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
            )
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))
        }

        item {
            // Action Grid
            ActionGrid()
        }
    }
}

@Composable
fun ActionGrid() {

    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ServiceCard(icon = getIconCargarDinero(), label = "CARGAR DINERO")
            ServiceCard(icon = getIconExtraerDinero(), label = "EXTRAER DINERO")
            ServiceCard(icon = getIconPrestamos(), label = "SEGUIR MIS PRESTAMOS")
        }
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ServiceCard(icon = getIconRecargaSube(), label = "RECARGA SUBE")
            ServiceCard(icon = getIconRecargaCelu(), label = "RECARGA CELU")
            ServiceCard(icon = getIconPagoServicio(), label = "PAGAR SERVICIO")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ServicePaymentScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController = navController)
}