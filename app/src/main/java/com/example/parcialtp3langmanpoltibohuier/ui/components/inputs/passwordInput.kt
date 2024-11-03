package com.example.parcialtp3langmanpoltibohuier.ui.components.inputs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Black
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Gray500
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Purple900
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Red900
import com.example.parcialtp3langmanpoltibohuier.ui.theme.White

@Composable
fun passwordInput(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    isError: Boolean,
    errorMessage: String? = null
) {
    var passwordVisible by remember { mutableStateOf(false) }

    var border = if(isError) Red900 else Gray500

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier
                .fillMaxWidth(),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                if (isError) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "!",
                            color = Red900,
                            style = MaterialTheme.typography.headlineMedium
                        )
                        val image =
                            if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(imageVector = image, contentDescription = null, tint = Gray500)
                        }
                    }
                } else {
                    val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, contentDescription = null, tint = Gray500)
                    }
                }
            },
            label = {
                Text(
                    text = "Contraseña",
                    color = if (value.isEmpty()) Black else Purple900,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Start
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = White,
                unfocusedContainerColor = White,
                focusedIndicatorColor = Purple900,
                unfocusedIndicatorColor = border,
                focusedTextColor = Black,
                unfocusedTextColor = Black
            )
        )
        if (isError && errorMessage != null) {
            Column(
                modifier = modifier.fillMaxWidth()

            ) {
                Text(
                    text = errorMessage,
                    color = Red900,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(top = 4.dp, start = 12.dp)
                        .align(Alignment.Start)
                )
            }
        }
    }
