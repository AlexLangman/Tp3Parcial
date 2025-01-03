package com.example.parcialtp3langmanpoltibohuier.ui.screens.home

import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
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
import com.example.parcialtp3langmanpoltibohuier.ui.components.popUps.cargarSubeBox
import com.example.parcialtp3langmanpoltibohuier.ui.components.popUps.cargarSubeConfirmacion
import com.example.parcialtp3langmanpoltibohuier.ui.components.showData.ShowDataEye
import com.example.parcialtp3langmanpoltibohuier.ui.screens.servicePayment.ServicePaymentViewModel
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
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = if (!isLoading && userInfo != null) ("👋 Hola " + userInfo!!.name.firstname) else "Cargando usuario...",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth(),
        )
        Text(
            text = "Último acceso: Mar 01, 2020 4:55 PM",
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
            item {
                GetCreditCard(
                    cardNumber = if (showInfo.value) creditCardNumber else creditCardNumberDefault,
                    expirationDate = if (showInfo.value) expirationDate else expirationDateDefault,
                )

                Spacer(modifier = Modifier.height(8.dp))

                ShowDataEye(onShowInfo = { showInfo.value = !showInfo.value })

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "SALDO DISPONIBLE",
                    style = MaterialTheme.typography.labelMedium,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground,
                )
                Text(
                    text = "$1.322,78",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(bottom = 16.dp),
                    fontSize = 44.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground,
                )

                Spacer(modifier = Modifier.height(8.dp))

                ExpiringFeeWarning()

                Spacer(modifier = Modifier.height(24.dp))

                ActionGrid()
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun ExpiringFeeWarning() {
    Box(
        modifier =
            Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clip(RoundedCornerShape(8.dp)) // Clip para redondear el fondo
                .background(Red900) // Color de fondo
                .padding(horizontal = 8.dp), // Espaciado interno
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically, // Asegura que el contenido esté centrado verticalmente
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(
                modifier =
                    Modifier
                        .padding(start = 12.dp, end = 12.dp),
                // Espaciado alrededor del contenido
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = "La cuota de tu préstamo está próxima a vencer.",
                    fontSize = 12.sp,
                    color = White,
                )
                Text(
                    text = "Ver préstamo",
                    style = TextStyle(textDecoration = TextDecoration.Underline),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = White,
                )
            }
            // Espaciador que empuja la imagen hacia la derecha
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.next_arrow),
                contentDescription = "Arrow",
                modifier =
                    Modifier
                        .size(16.dp)
                        .padding(end = 4.dp), // Espaciado final
            )
        }
    }
}

@Composable
fun ActionGrid() {
    val servicePaymentViewModel: ServicePaymentViewModel = viewModel()
    val isMainDialogOpen by servicePaymentViewModel.isMainDialogOpen
    val isConfirmationDialogOpen by servicePaymentViewModel.isConfirmationDialogOpen
    val context = LocalContext.current
    Card(
        modifier =
            Modifier
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline,
                    shape = RoundedCornerShape(8.dp),
                ).shadow(3.dp, RoundedCornerShape(8.dp)),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
        elevation = CardDefaults.cardElevation(0.dp),
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                ServiceCard(icon = getIconCargarDinero(), label = "CARGAR DINERO", onClick = {
                    Toast.makeText(context, "CARGAR DINERO", Toast.LENGTH_SHORT).show()
                })
                CustomVerticalDivider()
                ServiceCard(icon = getIconExtraerDinero(), label = "EXTRAER DINERO", onClick = {
                    Toast.makeText(context, "EXTRAER DINER", Toast.LENGTH_SHORT).show()
                })
                CustomVerticalDivider()
                ServiceCard(icon = getIconPrestamos(), label = "SEGUIR MIS PRESTAMOS", onClick = {
                    Toast.makeText(context, "SEGUIR MIS PRESTAMOS", Toast.LENGTH_SHORT).show()
                })
            }
            CustomHorizontalDivider()
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                ServiceCard(icon = getIconRecargaSube(), label = "RECARGA SUBE", onClick = { servicePaymentViewModel.openMainDialog() })
                CustomVerticalDivider()
                ServiceCard(icon = getIconRecargaCelu(), label = "RECARGA CELU", onClick = {
                    Toast.makeText(context, "RECARGA CELU", Toast.LENGTH_SHORT).show()
                })
                CustomVerticalDivider()
                ServiceCard(icon = getIconPagoServicio(), label = "PAGAR SERVICIO", onClick = {
                    Toast.makeText(context, "PAGAR SERVICIO", Toast.LENGTH_SHORT).show()
                })
            }
        }
        if (isMainDialogOpen) {
            cargarSubeBox(
                onDismiss = { servicePaymentViewModel.closeMainDialog() },
                onContinue = { servicePaymentViewModel.openConfirmationDialog() },
            )
        }

        if (isConfirmationDialogOpen) {
            cargarSubeConfirmacion(
                onDismiss = { servicePaymentViewModel.closeConfirmationDialog() },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ServicePaymentScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController = navController)
}
