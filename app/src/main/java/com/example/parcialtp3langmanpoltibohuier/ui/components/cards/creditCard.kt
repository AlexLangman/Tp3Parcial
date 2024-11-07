package com.example.parcialtp3langmanpoltibohuier.ui.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcialtp3langmanpoltibohuier.R

@Composable
fun CardContent(
    backgroundImage: Painter,
    overlayImage: Painter,
    brand: Painter,
    cardNumber: String,
    expirationDate: String,
) {
    Box(
        modifier =
            Modifier
                .clip(RoundedCornerShape(8.dp))
                .width(336.dp)
                .height(212.dp),
        contentAlignment = Alignment.Center, // Center the content
    ) {
        // Fondo y diseño de tarjeta
        Image(
            painter = backgroundImage,
            contentDescription = "Color de Fondo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize(),
        )
        Image(
            painter = overlayImage,
            contentDescription = "Diseño especifico sombreado",
            contentScale = ContentScale.Fit,
            modifier =
                Modifier
                    .align(Alignment.Center)
                    .fillMaxSize(),
        )
        Box(
            modifier =
                Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 24.dp, end = 24.dp), // Aplica el padding aquí
        ) {
            Image(
                painter = brand,
                contentDescription = "Brand",
                modifier = Modifier.size(50.dp), // Tamaño fijo para la imagen
            )
        }

        // Datos de la tarjeta
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(start = 24.dp, bottom = 24.dp),
            verticalArrangement = Arrangement.Bottom,
        ) {
            Text(
                text = cardNumber,
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp),
                color = Color.White,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = expirationDate,
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 20.sp),
                color = Color.White,
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        // Logo de Mastercard
        Box(
            modifier =
                Modifier
                    .align(Alignment.BottomEnd)
                    .padding(24.dp),
        ) {
            Box(
                modifier =
                    Modifier
                        .size(28.dp)
                        .offset(x = (-16).dp) // Desplaza el círculo hacia la izquierda
                        .background(Color(0xD9EB001B), shape = CircleShape), // Circulo Rojo
            )
            Box(
                modifier =
                    Modifier
                        .size(28.dp)
                        .background(Color(0xD9F79E1B), shape = CircleShape), // Circulo Naranja
            )
        }
    }
}

@Composable
fun GetCreditCard(
    cardNumber: String,
    expirationDate: String,
) {
    Box {
        CardContent(
            backgroundImage = painterResource(id = R.drawable.img_credit_p2),
            overlayImage = painterResource(id = R.drawable.img_credit_p1),
            brand = painterResource(id = R.drawable.waynimovil),
            cardNumber = cardNumber,
            expirationDate = expirationDate,
        )
    }
}

@Preview(showBackground = false)
@Composable
fun CreditCardPreview() {
    GetCreditCard(
        cardNumber = "4957 **** **** 5824",
        expirationDate = "12/23",
    )
}
