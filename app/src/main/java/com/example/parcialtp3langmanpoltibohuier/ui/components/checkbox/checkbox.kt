package com.example.parcialtp3langmanpoltibohuier.ui.components.checkbox

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.parcialtp3langmanpoltibohuier.R
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Gray500
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Green100
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Green800
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Purple900

@Composable
fun checkbox(
    checkedState: Int, // 0: sin seleccionar, 1: seleccionado, 2: seleccionado con verificación
    onCheckedChange: (Int) -> Unit,
    label: String,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
    ) {
        Box(
            modifier =
                Modifier
                    .size(24.dp)
                    .background(
                        color = if (checkedState == 2) Green100 else Color.Transparent,
                        shape = CircleShape,
                    ).border(
                        width = 1.dp,
                        color = if (checkedState == 2) Green800 else Gray500,
                        shape = CircleShape,
                    ).clickable {
                        val newState = if (checkedState == 0 || checkedState == 1) 2 else 0
                        onCheckedChange(newState)
                    },
            contentAlignment = Alignment.Center,
        ) {
            if (checkedState == 2) {
                Icon(
                    painter = painterResource(id = R.drawable.vector),
                    contentDescription = "Check",
                    tint = Green800,
                    modifier = Modifier.size(16.dp),
                )
            } else if (checkedState == 1) {
                Box(
                    modifier =
                        Modifier
                            .size(10.dp)
                            .background(Purple900, CircleShape),
                )
            }
        }

        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0xFF241846),
        )
    }
}
