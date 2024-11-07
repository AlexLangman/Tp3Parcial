package com.example.parcialtp3langmanpoltibohuier.ui.screens.logIn

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.parcialtp3langmanpoltibohuier.ui.components.checkbox.checkbox
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.others.getIconTopLogin
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.others.getIconWaynimovil
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.singIn.getIconEmoji1
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.singIn.getIconEmoji2
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.singIn.getIconTexto1
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.singIn.getIconTexto2
import com.example.parcialtp3langmanpoltibohuier.ui.components.icons.singIn.getIconTrianguloDialogo
import com.example.parcialtp3langmanpoltibohuier.ui.components.inputs.passwordInput
import com.example.parcialtp3langmanpoltibohuier.ui.components.inputs.textInput
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Black
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Gray100
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Green800
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Green900
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Purple900
import com.example.parcialtp3langmanpoltibohuier.ui.theme.White
import com.example.parcialtp3langmanpoltibohuier.ui.theme.manropeFontFamily
import kotlinx.coroutines.delay

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
            .background(Green800),
        horizontalAlignment = Alignment.CenterHorizontally
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
    var startEmojiAnimation by remember { mutableStateOf(false) }
    var startTextAnimation by remember { mutableStateOf(false) }

    val emoji1OffsetX by animateDpAsState(targetValue = if (startEmojiAnimation) 0.dp else 200.dp)
    val emoji2OffsetX by animateDpAsState(targetValue = if (startEmojiAnimation) 0.dp else -200.dp)

    val text1Alpha by animateFloatAsState(targetValue = if (startTextAnimation) 1f else 0f)
    val text2Alpha by animateFloatAsState(targetValue = if (startTextAnimation) 1f else 0f)

    LaunchedEffect(Unit) {
        startEmojiAnimation = true
        delay(700)
        startTextAnimation = true
    }

    Column(
        modifier = Modifier
            .width(288.dp)
            .background(Green800)
            .size(288.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = getIconWaynimovil(),
            contentDescription = "Logo",
        )
        Spacer(modifier = Modifier.height(24.dp))
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
        ) {
            Row(
                modifier = Modifier
                    .width(262.dp)
                    .height(56.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .size(196.dp)
                        .alpha(text1Alpha)
                        .align(Alignment.CenterVertically),
                ) {
                    Row(
                        modifier = Modifier.width(50.dp),
                        horizontalArrangement = Arrangement.End

                    ){
                        Image(
                            painter = getIconTrianguloDialogo(),
                            contentDescription = "Triangulo de Dialogo"
                        )
                    }

                    Image(
                        painter = getIconTexto1(),
                        contentDescription = "UNA BILLETERA",
                        modifier = Modifier
                            .offset(y = (-8).dp)
                    )
                }
                Image(
                    painter = getIconEmoji1(),
                    contentDescription = "Emoji feliz",
                    modifier = Modifier
                        .offset(x = emoji1OffsetX)
                        .size(56.dp)
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier
                    .width(288.dp)
                    .height(37.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = getIconEmoji2(),
                    contentDescription = "Emoji manos",
                    modifier = Modifier
                        .offset(x = emoji2OffsetX)
                        .size(56.dp)
                )

                Box(
                    modifier = Modifier
                        .size(228.dp)
                        .alpha(text2Alpha)
                        .align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = getIconTexto2(),
                        contentDescription = "SIMPLE PARA VOS"
                    )
                }
            }
        }
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
    Box(modifier = Modifier
        .fillMaxSize()
        .clip(RoundedCornerShape(12.dp, 12.dp))
        .background(Gray100),
    ) {
        Column(
            modifier =
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
        Column(modifier = Modifier
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

            TextInput(
                value = uiState.username,
                onValueChange = { viewModel.onUsernameChange(it) },
                label = "DNI o E-mail",
                modifier = Modifier.fillMaxWidth(),
                isError = uiState.errorMessage != null,
                errorMessage = uiState.errorMessage,
            )

            Spacer(modifier = Modifier.height(8.dp))

            PasswordInput(
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

