package com.example.parcialtp3langmanpoltibohuier.ui.components.showData

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

fun onShowInfo(value: Boolean): Boolean = !value

@Composable
fun ShowDataEye(onShowInfo: () -> Unit) {
    val showInfoText = "Mostrar datos"

    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .clickable(onClick = { onShowInfo() }),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = Icons.Filled.Visibility,
            contentDescription = "Visibility Icon",
            tint = MaterialTheme.colorScheme.onBackground,
        )
        Text(
            text = showInfoText,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 5.dp),
        )
    }
}
