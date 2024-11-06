package com.example.parcialtp3langmanpoltibohuier.ui.screens.servicePayment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.parcialtp3langmanpoltibohuier.MainViewModel
import com.example.parcialtp3langmanpoltibohuier.ui.components.cards.bigServiceCard
import com.example.parcialtp3langmanpoltibohuier.ui.components.dialogs.cargarSubeBox
import com.example.parcialtp3langmanpoltibohuier.ui.components.dialogs.cargarSubeConfirmacion
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconDirectTv
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconPagoServicio
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconRecargaCelu
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.services.getIconRecargaSube


@Composable
fun ServicePaymentScreen(navController: NavHostController) {
    val services = listOf(
        Pair(getIconRecargaSube(), "RECARGA SUBE"),
        Pair(getIconRecargaCelu(), "RECARGA CELULAR"),
        Pair(getIconPagoServicio(), "PAGO DE SERVICIOS"),
        Pair(getIconDirectTv(), "DIRECT TV PREPAGO"),
    )

    val servicePaymentViewModel: ServicePaymentViewModel = viewModel()
    val isMainDialogOpen by servicePaymentViewModel.isMainDialogOpen
    val isConfirmationDialogOpen by servicePaymentViewModel.isConfirmationDialogOpen


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 70.dp),
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
                if(label != "RECARGA SUBE"){
                    bigServiceCard(icon = icon, label = label)
                }else{
                    bigServiceCard(icon = icon, label = label, onClick = { servicePaymentViewModel.openMainDialog() })
                }

            }
        }
    }
    if (isMainDialogOpen) {
        cargarSubeBox(
            onDismiss = { servicePaymentViewModel.closeMainDialog() },
            onContinue = { servicePaymentViewModel.openConfirmationDialog() }
        )
    }

    if (isConfirmationDialogOpen) {
        cargarSubeConfirmacion(
            onDismiss = { servicePaymentViewModel.closeConfirmationDialog() }
        )
    }
}

/*@Preview(showBackground = true)
@Composable
fun ServicePaymentScreenPreview() {
    val navController = rememberNavController()
    ServicePaymentScreen(navController = navController)
}*/