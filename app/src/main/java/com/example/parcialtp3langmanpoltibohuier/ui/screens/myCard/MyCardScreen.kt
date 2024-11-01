package com.example.parcialtp3langmanpoltibohuier.ui.screens.myCard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import androidx.compose.ui.graphics.Color
import com.example.parcialtp3langmanpoltibohuier.ui.components.cards.GetCreditCard
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Green2
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcialtp3langmanpoltibohuier.ui.components.buttons.arrowButton
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Gray1
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Purple1
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Yellow1

@Composable
fun MyCardScreen(navController: NavHostController){
    val TEXT1 = "TARJETA VIRTUAL"
    val TEXT2 = "TARJETA FISICA"
    val INFO = "¿Sabias que podes pedir una tarjeta Mastercad fisica para utilizar directamente en los negocios que vos elijas?"

    val SHOW_INFO_TEXT = "Mostrar datos"
    val SHOW_INFO = remember { mutableStateOf(true) }

    var CREDIT_CARD_NUMBER_DEFAULT = "**** **** **** ****"
    var CREDIT_CARD_NUMBER = "4957 **** **** 5824"
    var EXPIRATION_DATE_DEFAULT = "**/**"
    var EXPIRATION_DATE = "05/23"

    data class ButtonInfo(var title: String, var description: String, var icon: ImageVector, var buttonColor: Color)

    val buttonsInfo = listOf(
        ButtonInfo(title = "Quiero mi tarjeta fisica", description = "", icon = Icons.Filled.ArrowForward ,buttonColor = Green2),
        ButtonInfo(title = "Ya tengo mi tarjeta fisica", description = "Activa tu tarjeta para comenzar a usarla", icon = Icons.Filled.ArrowForward ,  buttonColor = Green2),
    )

    val modId = "modIcon"
    val FINAL_INFO = buildAnnotatedString {
        appendInlineContent(modId, "[icon]")
        append(INFO)
    }
    val inlineContent = mapOf(
        Pair(
            modId,
            InlineTextContent(
                Placeholder(
                    width = 20.sp,
                    height = 20.sp,
                    placeholderVerticalAlign = PlaceholderVerticalAlign.Center
                )
            ) {
                Icon(Icons.Filled.Lightbulb, contentDescription = null, tint = Yellow1, modifier = Modifier.fillMaxSize())
            }
        )
    )

    //Esta funcion se usa para mostrar/ocultar los datos de la tarjeta
    fun onShowInfo(){
        SHOW_INFO.value = !SHOW_INFO.value
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ){
            Column {
                Text(
                    text = TEXT1,
                    color = Gray1,
                    modifier = Modifier
                        .fillMaxWidth() // Ocupa todo el ancho disponible
                        .padding(start = 18.dp)
                )
                GetCreditCard(
                    cardNumber = if (SHOW_INFO.value) CREDIT_CARD_NUMBER else CREDIT_CARD_NUMBER_DEFAULT,
                    expirationDate = if (SHOW_INFO.value) EXPIRATION_DATE else EXPIRATION_DATE_DEFAULT
                )
                Row (
                    modifier = Modifier
                        .fillMaxWidth() // Ocupa todo el ancho disponible
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .clickable(onClick = { onShowInfo() }),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Visibility,
                        contentDescription = "Visibility Icon",
                        tint = Purple1
                    )
                    Text(
                        text = SHOW_INFO_TEXT,
                        color = Purple1,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 5.dp)
                    )
                }
            }
        }
        //Linea separadora
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
                .drawBehind {
                    drawLine(
                        color = Gray1, // Cambia el color del subrayado
                        start = Offset(0f, size.height), // Comienza en la parte inferior izquierda
                        end = Offset(
                            size.width,
                            size.height
                        ), // Termina en la parte inferior derecha
                        strokeWidth = 2f // Grosor del subrayado
                    )
                }
        )
        Box(){
            Column {
                Text(
                    text = FINAL_INFO,
                    inlineContent = inlineContent,
                    color = Gray1,
                    modifier = Modifier
                        .fillMaxWidth() // Ocupa todo el ancho disponible
                        .padding(start = 18.dp, end = 18.dp)
                )
                Text(
                    text = TEXT2,
                    color = Gray1,
                    modifier = Modifier
                        .fillMaxWidth() // Ocupa todo el ancho disponible
                        .padding(start = 18.dp)
                        .padding(top = 7.dp)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp)
                ){
                    Column(
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                    ) {
                        buttonsInfo.map {
                            arrowButton(
                                text = it.title,
                                description = it.description,
                                icon = it.icon,
                                iconBackgrounColor = it.buttonColor)
                        }
                    }
                }
            }
        }
    }
}