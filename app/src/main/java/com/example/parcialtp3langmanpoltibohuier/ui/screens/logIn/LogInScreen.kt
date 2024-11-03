package com.example.parcialtp3langmanpoltibohuier.ui.screens.logIn

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parcialtp3langmanpoltibohuier.R
import com.example.parcialtp3langmanpoltibohuier.ui.theme.*
import com.example.parcialtp3langmanpoltibohuier.ui.components.inputs.passwordInput
import com.example.parcialtp3langmanpoltibohuier.ui.components.inputs.textInput
import com.example.parcialtp3langmanpoltibohuier.ui.components.checkbox.checkbox

@Composable
fun LogInScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Green900)
    ) {
        HeaderSection()

        FormSection(navController)
    }
}

@Composable
fun HeaderSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Green900)
            .size(250.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.waynimovil),
                contentDescription = "Logo",
                modifier = Modifier.size(60.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painter = painterResource(id = R.drawable.union),
                contentDescription = "Logo",
                modifier = Modifier.size(180.dp)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.top),
            contentDescription = "Texto",
            modifier = Modifier
                .scale(2.5f)
                .offset(y = (-30).dp)
        )
    }
}

@Composable
fun FormSection(navController: NavHostController) {
    val viewModel: LogInViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()
    var checkedState by remember { mutableIntStateOf(0) }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(12.dp, 12.dp))
            .background(Gray100)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Ingresá a tu cuenta:",
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold, fontFamily = manropeFontFamily),
                color = Black,
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(24.dp))

            textInput(
                value = uiState.username,
                onValueChange = { viewModel.onUsernameChange(it) },
                label = "DNI o E-mail",
                modifier = Modifier.fillMaxWidth(),
                isError = uiState.errorMessage != null,
                errorMessage = uiState.errorMessage
            )

            Spacer(modifier = Modifier.height(8.dp))

            passwordInput(
                value = uiState.password,
                onValueChange = { viewModel.onPasswordChange(it) },
                modifier = Modifier.fillMaxWidth(),
                isError = uiState.errorMessage != null,
                errorMessage = uiState.errorMessage
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
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
                label = "Recordar datos de ingreso"
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { viewModel.onLoginClick(navController) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Purple900)
            ) {
                Text("Ingresar")
            }
        }
    }
}
