package com.example.parcialtp3langmanpoltibohuier.ui.screens.MyCard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.parcialtp3langmanpoltibohuier.ui.components.cards.GetCreditCard
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Green2
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Gray1
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Purple1

@Preview(showBackground = true)
@Composable
fun showMyCardScreen(){
    MyCardScreen()
}

//navController: NavHostController
@Composable
fun MyCardScreen(){
    val TEXT1 = "TARJETA VIRTUAL"
    val TEXT2 = "TARJETA FISICA"
    val INFO = "¿Sabias que podes pedir una tarjeta Mastercad fisica para utilizar directamente en los negocios que vos elijas?"

    val SHOW_INFO_TEXT = "Mostrar datos"
    val SHOW_INFO = remember { mutableStateOf(true) }

    var CREDIT_CARD_NUMBER_DEFAULT = "**** **** **** ****"
    var CREDIT_CARD_NUMBER = "4957 **** **** 5824"
    var EXPIRATION_DATE_DEFAULT = "**/**"
    var EXPIRATION_DATE = "05/23"

    data class ButtonInfo(var title: String, var description: String, var buttonColor: Color)

    val buttonsInfo = listOf(
        ButtonInfo(title = "Quiero mi tarjeta fisica", description = "", buttonColor = Green2),
        ButtonInfo(title = "Ya tengo mi tarjeta fisica", description = "Activa tu tarjeta para comenzar a usarla", buttonColor = Green2),
    )

    //Esta funcion se usa para mostrar/ocultar los datos de la tarjeta
    fun onShowInfo(){
        SHOW_INFO.value = !SHOW_INFO.value
    }

    Column {
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
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
                .drawBehind {
                    drawLine(
                        color = Gray1, // Cambia el color del subrayado
                        start = Offset(0f, size.height), // Comienza en la parte inferior izquierda
                        end = Offset(size.width, size.height), // Termina en la parte inferior derecha
                        strokeWidth = 2f // Grosor del subrayado
                    )
                }
        )
        Box(){}
    }
}