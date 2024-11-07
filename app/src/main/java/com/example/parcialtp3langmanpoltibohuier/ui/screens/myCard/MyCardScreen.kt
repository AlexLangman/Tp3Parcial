package com.example.parcialtp3langmanpoltibohuier.ui.screens.myCard

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.parcialtp3langmanpoltibohuier.ui.components.buttons.arrowButton
import com.example.parcialtp3langmanpoltibohuier.ui.components.cards.GetCreditCard
import com.example.parcialtp3langmanpoltibohuier.ui.components.showData.ShowDataEye
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Gray900
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Green800
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Yellow900

const val TEXT1 = "TARJETA VIRTUAL"
const val TEXT2 = "TARJETA FISICA"
const val INFO = "¿Sabias que podes pedir una tarjeta Mastercad fisica para utilizar directamente en los negocios que vos elijas?"
const val CREDIT_CARD_NUMBER_DEFAULT = "**** **** **** ****"
const val CREDIT_CARD_NUMBER = "4957 **** **** 5824"
const val EXPIRATION_DATE_DEFAULT = "**/**"
const val EXPIRATION_DATE = "05/23"
const val MOD_ID = "modIcon"

@Composable
fun MyCardScreen(navController: NavHostController) {
    val showInfo = remember { mutableStateOf(true) }

    val context = LocalContext.current

    data class ButtonInfo(
        var title: String,
        var description: String,
        var icon: ImageVector,
        var buttonColor: Color,
        var isFirst: Boolean = false,
        var isLast: Boolean = false,
        var action: () -> Unit = { Toast.makeText(context, title, Toast.LENGTH_SHORT).show() },
    )

    val buttonsInfo =
        listOf(
            ButtonInfo(
                title = "Quiero mi tarjeta fisica",
                description = "",
                icon = Icons.Filled.ArrowForward,
                buttonColor = Green800,
                isFirst = true,
            ),
            ButtonInfo(
                title = "Ya tengo mi tarjeta fisica",
                description = "Activa tu tarjeta para comenzar a usarla",
                icon = Icons.Filled.ArrowForward,
                buttonColor = Green800,
                isLast = true,
            ),
        )

    val finalInfo =
        buildAnnotatedString {
            appendInlineContent(MOD_ID, "[icon]")
            append(INFO)
        }

    val inlineContent =
        mapOf(
            Pair(
                MOD_ID,
                InlineTextContent(
                    Placeholder(
                        width = 20.sp,
                        height = 20.sp,
                        placeholderVerticalAlign = PlaceholderVerticalAlign.Center,
                    ),
                ) {
                    Icon(Icons.Filled.Lightbulb, contentDescription = null, tint = Yellow900, modifier = Modifier.fillMaxSize())
                },
            ),
        )

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Box(modifier = Modifier.fillMaxWidth()) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = TEXT1,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 18.dp),
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                    GetCreditCard(
                        cardNumber = if (showInfo.value) CREDIT_CARD_NUMBER else CREDIT_CARD_NUMBER_DEFAULT,
                        expirationDate = if (showInfo.value) EXPIRATION_DATE else EXPIRATION_DATE_DEFAULT,
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    ShowDataEye(onShowInfo = { showInfo.value = !showInfo.value })
                }
            }
        }
        // Linea separadora
        item {
            Box(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                        .drawBehind
                        {
                            drawLine(
                                color = Gray900, // Cambia el color del subrayado
                                start = Offset(0f, size.height), // Comienza en la parte inferior izquierda
                                end =
                                    Offset(
                                        size.width,
                                        size.height,
                                    ),
                                // Termina en la parte inferior derecha
                                strokeWidth = 2f, // Grosor del subrayado
                            )
                        },
            )
        }
        item {
            Box {
                Column {
                    Text(
                        text = finalInfo,
                        inlineContent = inlineContent,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier =
                            Modifier
                                .fillMaxWidth() // Ocupa todo el ancho disponible
                                .padding(start = 18.dp, end = 18.dp),
                    )
                    Text(
                        text = TEXT2,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier =
                            Modifier
                                .fillMaxWidth() // Ocupa todo el ancho disponible
                                .padding(start = 18.dp)
                                .padding(top = 7.dp),
                    )
                    Box(
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 18.dp),
                    ) {
                        Column(
                            modifier =
                                Modifier
                                    .padding(vertical = 10.dp),
                        ) {
                            buttonsInfo.map {
                                arrowButton(
                                    text = it.title,
                                    description = it.description,
                                    icon = it.icon,
                                    iconBackgrounColor = it.buttonColor,
                                    isLast = it.isLast,
                                    isFirst = it.isFirst,
                                    action = it.action,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyCardScreenPreview() {
    val navController = rememberNavController()
    MyCardScreen(navController)
}
