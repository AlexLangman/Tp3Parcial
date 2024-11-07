package com.example.parcialtp3langmanpoltibohuier.ui.components.popUps

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import com.example.parcialtp3langmanpoltibohuier.ui.components.buttons.customButton
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.others.getIconSube

@Composable
fun cargarSubeBox(
    onDismiss: () -> Unit,
    onContinue: () -> Unit,
) {
    Popup(
        onDismissRequest = onDismiss,
    ) {
        Column(
            modifier =
                Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .fillMaxSize(),
        ) {
            topBarDialog(onDismiss)
            Spacer(modifier = Modifier.height(48.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier =
                    Modifier
                        .padding(16.dp),
            ) {
                Text(
                    text = "Verificá que la información sea correcta:",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onBackground,
                )

                Spacer(modifier = Modifier.height(16.dp))

                boxSube()

                Spacer(modifier = Modifier.weight(1f))

                customButton(
                    onClick = onContinue,
                    text = "Continuar",
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun boxSube() {
    Column(
        modifier =
            Modifier
                .clip(RoundedCornerShape(8.dp))
                .shadow(1.dp)
                .border(1.dp, MaterialTheme.colorScheme.outline),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = getIconSube(),
            contentDescription = "sube",
        )
        HorizontalDivider(Modifier.padding(vertical = 16.dp))
        Text(
            text = "Tarjeta Nº: 6061 3580 2384 9041",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground,
        )
        HorizontalDivider(Modifier.padding(vertical = 16.dp))
        Text(
            text = "$ 200,00",
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.onBackground,
        )
    }
}

/*@Preview(showBackground = true)
@Composable
fun CargarSubeBoxPreview(){
    cargarSubeBox({true})
}*/
