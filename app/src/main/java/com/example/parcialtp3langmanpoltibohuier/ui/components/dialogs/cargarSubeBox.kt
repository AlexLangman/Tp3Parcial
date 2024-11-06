package com.example.parcialtp3langmanpoltibohuier.ui.components.dialogs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parcialtp3langmanpoltibohuier.MainViewModel
import com.example.parcialtp3langmanpoltibohuier.ui.components.buttons.customButton
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.others.getIconSube
import com.example.parcialtp3langmanpoltibohuier.ui.components.topBar.topBarCustom
import com.example.parcialtp3langmanpoltibohuier.ui.theme.White
import kotlin.io.path.fileVisitor

@Composable
fun cargarSubeBox(onDismiss: () -> Unit, onContinue: () -> Unit){
    Dialog(
        onDismissRequest = onDismiss,
    )
    {
        Column (
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            topBarDialog(onDismiss)
            Spacer(modifier = Modifier.height(48.dp))
            Text(
                text = "Verificá que la información sea correcta:",
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
            )

            Spacer(modifier = Modifier.height(16.dp))

            boxSube()

            Spacer(modifier = Modifier.weight(1f))

            customButton(
                onClick = onContinue ,
                text = "Continuar"
            )
            Spacer(modifier = Modifier.height(16.dp))

        }
    }

}


@Composable
fun boxSube(){
    Column (
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .shadow(1.dp)
            .border(1.dp, MaterialTheme.colorScheme.primary)/*TODO: color borde*/,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = getIconSube(),
            contentDescription = "sube",
        )
        HorizontalDivider(Modifier.padding(vertical = 16.dp))
        Text(
            text = "Tarjeta Nº: 6061 3580 2384 9041",
            style = MaterialTheme.typography.bodyLarge,
        )
        HorizontalDivider(Modifier.padding(vertical = 16.dp))
        Text(
            text = "$ 200,00",
            style = MaterialTheme.typography.displaySmall
        )


    }
}

/*@Preview(showBackground = true)
@Composable
fun CargarSubeBoxPreview(){
    cargarSubeBox({true})
}*/