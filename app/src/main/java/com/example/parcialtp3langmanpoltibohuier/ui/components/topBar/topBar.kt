package com.example.parcialtp3langmanpoltibohuier.ui.components.topBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcialtp3langmanpoltibohuier.ui.navigation.AppRoutes
import com.example.parcialtp3langmanpoltibohuier.ui.navigation.TopBarTitles
import com.google.firebase.annotations.concurrent.Background

@Composable
fun topBarCustom(
    currentRoute : String
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(MaterialTheme.colorScheme.background),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            TopBarTitles.getTitle(currentRoute),
            // TODO: ponerle el style que le va
            color = MaterialTheme.colorScheme.onBackground,
            )
    }
}

@Preview(showBackground = true)
@Composable
fun topBarCustomPreview(){
    topBarCustom(currentRoute = AppRoutes.HOME)
}