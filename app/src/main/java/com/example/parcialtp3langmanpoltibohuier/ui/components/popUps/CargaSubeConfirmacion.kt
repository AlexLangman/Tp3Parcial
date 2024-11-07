package com.example.parcialtp3langmanpoltibohuier.ui.components.popUps

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.example.parcialtp3langmanpoltibohuier.ui.components.buttons.customButton
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.others.getIconOk

@Composable
fun cargarSubeConfirmacion(onDismiss: () -> Unit) {
    Popup(onDismissRequest = { onDismiss }) {
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
        ) {
            topBarDialog(onDismiss, false)

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier =
                    Modifier
                        .padding(16.dp),
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = getIconOk(),
                    contentDescription = "Ok",
                    modifier = Modifier.size(96.dp),
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Tu operación se ha realizado con éxito",
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onBackground,
                )
                Spacer(modifier = Modifier.weight(1f))
                customButton(
                    onClick = onDismiss,
                    text = "Finalizar",
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

/*@Preview(showBackground = true)
@Composable
fun CargarSubeConfirmacionPreview(){
    cargarSubeConfirmacion()
}*/
