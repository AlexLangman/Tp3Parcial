package com.example.parcialtp3langmanpoltibohuier.ui.components.dialogs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.others.getIconBack
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.others.getIconClose


@Composable
fun topBarDialog(
    onDismiss : () -> Unit,
    haveBackButton : Boolean = true
){
    val title = "Cargar Sube"
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(MaterialTheme.colorScheme.background),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if(haveBackButton){
            iconstopBarDialog(
                icon = getIconBack(),
                onClick =  onDismiss ,
                contentDescription = "back"
            )
        }else{
            Box(){}
        }

        Text(
            title,
            // TODO: ponerle el style que le va
            color = MaterialTheme.colorScheme.onBackground,
        )
        iconstopBarDialog(
            icon = getIconClose(),
            onClick = onDismiss,
            contentDescription = "close"
        )
    }
}

@Composable
fun iconstopBarDialog(
    icon : Painter,
    onClick : () -> Unit,
    contentDescription : String
){
    Image(
        painter = icon,
        contentDescription = contentDescription,
        modifier = Modifier
            .size(20.dp)
            .clickable { onClick() }
    )
}