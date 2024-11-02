package com.example.parcialtp3langmanpoltibohuier.ui.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Red1
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Yellow1
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Yellow2
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Yellow3

@Composable
fun CardContent(
    backgroundImage: Painter,
    overlayImage: Painter,
    cardNumber: String,
    expirationDate: String
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
    ) {
        Image(
            painter = backgroundImage,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize() // Matches size with Box
        )
        Image(
            painter = overlayImage,
            contentDescription = null,
            contentScale = ContentScale.Fit, // Use Fit to ensure it shows correctly
            modifier = Modifier
                .align(Alignment.Center) // Center the overlay image
                .matchParentSize() // Set a specific size for the overlay image
        )
        // Column for text fields, aligned at the bottom
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 16.dp, start = 16.dp),
            verticalArrangement = Arrangement.Bottom,

            ) {
            Text(
                text = cardNumber,
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp),
                color = Color.White
            )
            Text(
                text = expirationDate,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(18.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(25.dp)
                    .background(Yellow1.copy(alpha = 0.85f), shape = CircleShape)
            )
            Box(
                modifier = Modifier
                    .size(25.dp)
                    .offset(x = (-16).dp) // Desplaza el segundo círculo hacia la izquierda para superponerlo
                    .background(Red1.copy(alpha = 0.85f), shape = CircleShape) // Amarillo
            )
        }
    }
}

@Composable
fun GetCreditCard(cardNumber: String, expirationDate: String) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(8.dp))
            .height(200.dp),
        contentAlignment = Alignment.Center // Center the content
    ) {
        CardContent(
            backgroundImage = painterResource(id = R.drawable.img_credit_p2),
            overlayImage = painterResource(id = R.drawable.img_credit_p1),
            cardNumber = cardNumber,
            expirationDate = expirationDate
        )
    }
}

@Preview(showBackground = false)
@Composable
fun CreditCardPreview() {
    GetCreditCard(cardNumber = "4957 **** **** 5824", expirationDate = "12/23")
}
