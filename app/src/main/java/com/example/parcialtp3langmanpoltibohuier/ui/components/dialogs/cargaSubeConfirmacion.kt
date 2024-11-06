package com.example.parcialtp3langmanpoltibohuier.ui.components.dialogs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.parcialtp3langmanpoltibohuier.ui.components.buttons.customButton
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.others.getIconOk

@Composable
fun cargarSubeConfirmacion(onDismiss: () -> Unit){
    Dialog(onDismissRequest = { onDismiss }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            topBarDialog(onDismiss, false)
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = getIconOk(),
                contentDescription = "Ok",
                modifier = Modifier.size(96.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Verificá que la información sea correcta:",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.weight(1f))
            customButton(
                onClick = onDismiss ,
                text = "Finalizar"
            )
            Spacer(modifier = Modifier.height(16.dp))

        }
    }

}

/*@Preview(showBackground = true)
@Composable
fun CargarSubeConfirmacionPreview(){
    cargarSubeConfirmacion()
}*/