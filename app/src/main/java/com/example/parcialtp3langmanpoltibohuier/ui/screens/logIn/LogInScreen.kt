package com.example.parcialtp3langmanpoltibohuier.ui.screens.logIn

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.parcialtp3langmanpoltibohuier.ui.components.checkbox.checkbox
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.others.getIconTopLogin
import com.example.parcialtp3langmanpoltibohuier.ui.components.inputs.passwordInput
import com.example.parcialtp3langmanpoltibohuier.ui.components.inputs.textInput
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Black
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Gray100
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Green900
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Purple900
import com.example.parcialtp3langmanpoltibohuier.ui.theme.White
import com.example.parcialtp3langmanpoltibohuier.ui.theme.manropeFontFamily

@Composable
fun LogInScreen(navController: NavHostController) {
    var isFormVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        isFormVisible = true
    }

    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .background(Green900),
    ) {
        HeaderSection()

        AnimatedVisibility(
            visible = isFormVisible,
            enter = slideInVertically(initialOffsetY = { it }, animationSpec = tween(500)),
        ) {
            FormSection(navController)
        }
    }
}

@Composable
fun HeaderSection() {
    Column(
        modifier =
            Modifier
                .fillMaxWidth()
                .background(Green900)
                .size(250.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = getIconTopLogin(),
            contentDescription = "Top Login",
            modifier = Modifier.size(288.dp),
        )
    }
}

@Composable
fun FormSection(navController: NavHostController) {
    val viewModel: LogInViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()
    var checkedState by remember { mutableIntStateOf(0) }

    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(12.dp, 12.dp))
                .background(Gray100),
    ) {
        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Ingresá a tu cuenta:",
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold, fontFamily = manropeFontFamily),
                color = Black,
                modifier = Modifier.align(Alignment.Start),
            )

            Spacer(modifier = Modifier.height(24.dp))

            textInput(
                value = uiState.username,
                onValueChange = { viewModel.onUsernameChange(it) },
                label = "DNI o E-mail",
                modifier = Modifier.fillMaxWidth(),
                isError = uiState.errorMessage != null,
                errorMessage = uiState.errorMessage,
            )

            Spacer(modifier = Modifier.height(8.dp))

            passwordInput(
                value = uiState.password,
                onValueChange = { viewModel.onPasswordChange(it) },
                modifier = Modifier.fillMaxWidth(),
                isError = uiState.errorMessage != null,
                errorMessage = uiState.errorMessage,
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
            ) {
                TextButton(onClick = {}) {
                    Text(text = "Olvidé mi contraseña", color = Purple900)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            checkbox(
                checkedState = checkedState,
                onCheckedChange = { newState ->
                    checkedState = newState
                },
                label = "Recordar datos de ingreso",
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { viewModel.onLoginClick(navController) },
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                colors =
                    ButtonDefaults.buttonColors(
                        containerColor = Purple900,
                        contentColor = White,
                    ),
            ) {
                Text("Ingresar")
            }
        }
    }
}
