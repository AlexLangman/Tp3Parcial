package com.example.parcialtp3langmanpoltibohuier.ui.components.buttons

import ThemeViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SwitchThemeButton(
    action: () -> Unit,
    isDark: Boolean,
) {
    Switch(
        checked = isDark,
        onCheckedChange = {
            action()
        },
        colors =
            SwitchDefaults.colors(
                checkedThumbColor = MaterialTheme.colorScheme.primary,
                checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
                uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
    )
}

@Composable
fun SwitchThemeComponent(themeViewModel: ThemeViewModel = viewModel()) {
    val isDarkTheme by themeViewModel.isDarkTheme.observeAsState(false)
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(5.dp),
                ).padding(5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier =
                Modifier
                    .height(56.dp),
        ) {
            Text(
                text = if (isDarkTheme) "Dark Mode" else "Light Mode",
                color = MaterialTheme.colorScheme.onBackground, // Cambia el color de la letra a negro
                fontWeight = FontWeight.Bold, // Cambia la letra a negrita
            )
        }
        Box(
            modifier =
                Modifier
                    .size(60.dp) // Tamaño del círculo
                    .clip(CircleShape),
            // Forma circular
            contentAlignment = Alignment.Center,
        ) {
            SwitchThemeButton(action = { themeViewModel.toggleTheme() }, isDark = isDarkTheme)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SwitchThemeComponentPreview() {
    SwitchThemeComponent()
}
