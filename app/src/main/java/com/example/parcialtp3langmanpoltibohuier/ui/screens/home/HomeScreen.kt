package com.example.parcialtp3langmanpoltibohuier.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.parcialtp3langmanpoltibohuier.R
import com.example.parcialtp3langmanpoltibohuier.ui.components.cards.GetCreditCard
import com.example.parcialtp3langmanpoltibohuier.ui.components.cards.ServiceCard
import com.example.parcialtp3langmanpoltibohuier.ui.components.dividers.CustomHorizontalDivider
import com.example.parcialtp3langmanpoltibohuier.ui.components.dividers.CustomVerticalDivider
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconCargarDinero
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconExtraerDinero
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconPagoServicio
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconPrestamos
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconRecargaCelu
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconRecargaSube
import com.example.parcialtp3langmanpoltibohuier.ui.components.showData.ShowDataEye
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Black
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Gray500
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Gray900
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Red900
import com.example.parcialtp3langmanpoltibohuier.ui.theme.White

@Composable
fun HomeScreen(navController: NavHostController) {
    val viewModel: HomeViewModel = viewModel()
    val isLoading by viewModel.loading.collectAsState()
    val userInfo by viewModel.userInfo.collectAsState()

    val showInfo = remember { mutableStateOf(true) }
    val creditCardNumberDefault = "**** **** **** ****"
    val creditCardNumber = "4957 **** **** 5824"
    val expirationDateDefault = "**/**"
    val expirationDate = "05/23"

    LaunchedEffect(Unit) {
        viewModel.getUserById(1) // Traemos la info del usuario 1
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = if (!isLoading && userInfo != null) ("👋 Hola " + userInfo!!.name.firstname) else "Cargando usuario...",
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Último acceso: Mar 01, 2020 4:55 PM",
            style = MaterialTheme.typography.bodySmall,
            color = Gray900,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        GetCreditCard(
            cardNumber = if (showInfo.value) creditCardNumber else creditCardNumberDefault,
            expirationDate = if (showInfo.value) expirationDate else expirationDateDefault
        )

        ShowDataEye(onShowInfo = { showInfo.value = !showInfo.value })

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "SALDO DISPONIBLE",
            style = MaterialTheme.typography.labelMedium,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Black
        )
        Text(
            text = "$1.322,78",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp),
            fontSize = 44.sp,
            fontWeight = FontWeight.Bold,
            color = Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        ExpiringFeeWarning()

        Spacer(modifier = Modifier.height(24.dp))

        ActionGrid()
    }
}

@Composable
fun ExpiringFeeWarning() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .border(
                width = 1.dp,
                color = Gray500,
                shape = RoundedCornerShape(8.dp)
            )
            .clip(RoundedCornerShape(8.dp)) // Clip para redondear el fondo
            .background(Red900) // Color de fondo
            .padding(horizontal = 8.dp) // Espaciado interno
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically, // Asegura que el contenido esté centrado verticalmente
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 12.dp,end = 12.dp), // Espaciado alrededor del contenido
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "La cuota de tu préstamo está próxima a vencer.",
                    fontSize = 12.sp,
                    color = White
                )
                Text(
                    text = "Ver préstamo",
                    style = TextStyle(textDecoration = TextDecoration.Underline),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = White
                )

            }
            // Espaciador que empuja la imagen hacia la derecha
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.next_arrow),
                contentDescription = "Arrow",
                modifier = Modifier
                    .size(16.dp)
                    .padding(end = 4.dp) // Espaciado final
            )
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
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ServiceCard(icon = getIconCargarDinero(), label = "CARGAR DINERO")
                CustomVerticalDivider()
                ServiceCard(icon = getIconExtraerDinero(), label = "EXTRAER DINERO")
                CustomVerticalDivider()
                ServiceCard(icon = getIconPrestamos(), label = "SEGUIR MIS PRESTAMOS")
            }
            CustomHorizontalDivider()
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ServiceCard(icon = getIconRecargaSube(), label = "RECARGA SUBE")
                CustomVerticalDivider()
                ServiceCard(icon = getIconRecargaCelu(), label = "RECARGA CELU")
                CustomVerticalDivider()
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