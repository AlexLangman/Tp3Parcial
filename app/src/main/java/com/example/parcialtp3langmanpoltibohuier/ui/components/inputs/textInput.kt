package com.example.parcialtp3langmanpoltibohuier.ui.components.inputs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Black
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Gray500
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Purple900
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Red900
import com.example.parcialtp3langmanpoltibohuier.ui.theme.White

@Composable
fun textInput(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    isError: Boolean,
    errorMessage: String? = null,
) {
    var border = if (isError) Red900 else Gray500

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        trailingIcon = {
            if (isError) {
                Text(
                    text = "!",
                    color = Red900,
                    style = MaterialTheme.typography.headlineMedium,
                )
            }
        },
        label = {
            Text(
                text = label,
                color = if (value.isEmpty()) Black else Purple900,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Start,
            )
        },
        modifier = modifier,
        colors =
            TextFieldDefaults.colors(
                focusedContainerColor = White,
                unfocusedContainerColor = White,
                focusedIndicatorColor = Purple900,
                unfocusedIndicatorColor = border,
                focusedTextColor = Black,
                unfocusedTextColor = Black,
            ),
    )

    if (isError && errorMessage != null) {
        Column(
            modifier = modifier.fillMaxWidth(),
        ) {
            Text(
                text = errorMessage,
                color = Red900,
                style = MaterialTheme.typography.bodyMedium,
                modifier =
                    Modifier
                        .padding(top = 4.dp, start = 12.dp)
                        .align(Alignment.Start),
            )
        }
    }
}
