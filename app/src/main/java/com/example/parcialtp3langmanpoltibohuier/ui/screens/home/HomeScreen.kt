package com.example.parcialtp3langmanpoltibohuier.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.parcialtp3langmanpoltibohuier.ui.components.cards.GetCreditCard
import com.example.parcialtp3langmanpoltibohuier.ui.components.cards.ServiceCard
import com.example.parcialtp3langmanpoltibohuier.ui.components.dividers.horizontalDivider
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.others.getIconShow
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconCargarDinero
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconExtraerDinero
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconPagoServicio
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconPrestamos
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconRecargaCelu
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconRecargaSube
import com.example.parcialtp3langmanpoltibohuier.ui.screens.myProfile.MyProfileViewModel
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Gray500
import com.example.parcialtp3langmanpoltibohuier.ui.theme.White

@Composable
fun HomeScreen(navController: NavHostController) {
    val viewModel: HomeViewModel = viewModel()
    val isLoading by viewModel.loading.collectAsState()
    val userInfo by viewModel.userInfo.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getUserById(1) // Traemos la info del usuario 1
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Greeting
        item {
            Text(
                text = if (!isLoading && userInfo != null) ("👋 Hola " + userInfo!!.name.firstname) else "Cargando usuario...",
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
                Image(
                    painter = getIconShow(),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = "Mostrar datos",
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(start = 2.dp)
                )
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
    Card(
        modifier = Modifier
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
                ServiceCard(icon = getIconPrestamos(), label = "SEGUIR MIS PRESTAMOS")
            }
            HorizontalDivider(thickness = 1.dp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ServiceCard(icon = getIconRecargaSube(), label = "RECARGA SUBE")
                VerticalDivider(thickness = 1.dp, modifier = Modifier.height(96.dp))
                ServiceCard(icon = getIconRecargaCelu(), label = "RECARGA CELU")
                VerticalDivider(thickness = 1.dp, modifier = Modifier.height(96.dp))
                ServiceCard(icon = getIconPagoServicio(), label = "PAGAR SERVICIO")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ServicePaymentScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController = navController)
}