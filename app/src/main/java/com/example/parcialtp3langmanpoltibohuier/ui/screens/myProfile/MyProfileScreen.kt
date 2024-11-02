package com.example.parcialtp3langmanpoltibohuier.ui.screens.myProfile

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

import androidx.navigation.NavHostController
import com.example.parcialtp3langmanpoltibohuier.R
import com.example.parcialtp3langmanpoltibohuier.ui.components.buttons.arrowButton
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Green800

@Composable
fun MyProfileScreen(navController: NavHostController){
    LazyColumn (
        modifier = Modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        data class ButtonInfo(
            var title: String,
            var description: String,
            var icon: ImageVector,
            var buttonColor: Color,
            var isLast: Boolean = false,
            var isFirst: Boolean = false

        )

        val buttonsInfo = listOf(
            ButtonInfo(
                title = "Mis datos",
                description = "",
                icon = Icons.Filled.ArrowForward,
                buttonColor = Green800,
                isFirst = true
            ),
            ButtonInfo(
                title = "Mi CVU",
                description = "",
                icon = Icons.Filled.ArrowForward,
                buttonColor = Green800
            ),
            ButtonInfo(
                title = "Configuración",
                description = "",
                icon = Icons.Filled.ArrowForward,
                buttonColor = Green800
            ),
            ButtonInfo(
                title = "Ayuda",
                description = "",
                icon = Icons.Filled.ArrowForward,
                buttonColor = Green800
            ),
            ButtonInfo(
                title = "Términos y condiciones",
                description = "",
                icon = Icons.Filled.ArrowForward,
                buttonColor = Green800
            ),
            ButtonInfo(
                title = "Cerrar sesión",
                description = "",
                icon = Icons.Filled.ArrowForward,
                buttonColor = Green800,
                isLast = true
            ),

        )
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(R.drawable.profileimage),
                    contentDescription = "imagen de perfil"
                )

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    "\uD83D\uDC4B Hola Mariana Belén",
                )
            }


            Spacer(modifier = Modifier.height(32.dp))

            Column(
            ) {
                buttonsInfo.map {
                    arrowButton(
                        text = it.title,
                        description = it.description,
                        icon = it.icon,
                        iconBackgrounColor = it.buttonColor,
                        isFirst = it.isFirst,
                        isLast = it.isLast
                    )
                }
            }
            Spacer(modifier = Modifier.height(64.dp))

            arrowButton(
                text = "Dark Mode",
                description = "",
                icon = Icons.Filled.ArrowForward,
                iconBackgrounColor = Green800,
                isOnlyOne = true)
        }
    }
}