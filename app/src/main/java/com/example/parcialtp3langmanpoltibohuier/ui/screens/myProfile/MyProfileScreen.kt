package com.example.parcialtp3langmanpoltibohuier.ui.screens.myProfile

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.parcialtp3langmanpoltibohuier.MainViewModel
import com.example.parcialtp3langmanpoltibohuier.R
import com.example.parcialtp3langmanpoltibohuier.dataClasses.UserDataClass
import com.example.parcialtp3langmanpoltibohuier.ui.components.buttons.SwitchThemeComponent
import com.example.parcialtp3langmanpoltibohuier.ui.components.buttons.arrowButton
import com.example.parcialtp3langmanpoltibohuier.ui.navigation.AppRoutes
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Green800
import kotlinx.coroutines.CoroutineScope


@SuppressLint("UnrememberedMutableState")
@Composable
fun MyProfileScreen(
    navController: NavHostController,
    mainViewModel: MainViewModel,
    coroutineScope: CoroutineScope
) {
    val viewModel: MyProfileViewModel = viewModel()
    val isLoading by viewModel.loading.collectAsState()
    val userInfo by viewModel.userInfo.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getUserById(1)
    }
    Column(){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Mi Perfil",
                // TODO: ponerle el style que le va
                color = MaterialTheme.colorScheme.onBackground,
            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                ProfileHeader(isLoading = isLoading, userInfo = userInfo)
                Spacer(modifier = Modifier.height(32.dp))
                ProfileOptions(navController, mainViewModel, coroutineScope)
                Spacer(modifier = Modifier.height(64.dp))
                //DarkModeButton()
                SwitchThemeComponent()
            }
        }
    }
}

@Composable
fun ProfileHeader(isLoading: Boolean, userInfo: UserDataClass?) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(R.drawable.profileimage),
            contentDescription = "imagen de perfil"
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (!isLoading && userInfo != null) {
            Text(
                "\uD83D\uDC4B Hola " +
                        userInfo!!.name.firstname + " " +
                        userInfo!!.name.lastname
            )
        } else {
            Text(text = "Cargando nombre...")
        }
    }
}

@Composable
fun ProfileOptions(navController: NavHostController, mainViewModel: MainViewModel, coroutineScope: CoroutineScope) {
    data class ButtonInfo(
        var title: String,
        var description: String,
        var icon: ImageVector,
        var buttonColor: Color,
        var isLast: Boolean = false,
        var isFirst: Boolean = false,
        var action: () -> Unit = {}

    )
    val buttonsInfo = listOf(
        ButtonInfo("Mis datos", "", Icons.Filled.ArrowForward, Green800, isFirst = true),
        ButtonInfo("Mi CVU", "", Icons.Filled.ArrowForward, Green800),
        ButtonInfo("Configuración", "", Icons.Filled.ArrowForward, Green800),
        ButtonInfo("Ayuda", "", Icons.Filled.ArrowForward, Green800),
        ButtonInfo("Términos y condiciones", "", Icons.Filled.ArrowForward, Green800),
        ButtonInfo("Cerrar sesión", "", Icons.Filled.ArrowForward, Green800, isLast = true, action={closeSession(
            navController,
            mainViewModel,
            coroutineScope
        )})
    )

    Column {
        buttonsInfo.forEach { button ->
            arrowButton(
                text = button.title,
                description = button.description,
                icon = button.icon,
                iconBackgrounColor = button.buttonColor,
                isFirst = button.isFirst,
                isLast = button.isLast,
                action = button.action
            )
        }

    }
}

fun closeSession(navController: NavHostController, mainViewModel: MainViewModel, coroutineScope: CoroutineScope) {
    mainViewModel.toggleDrawer(
        coroutineScope,
        mainViewModel.drawerState
    )
    navController.navigate(AppRoutes.LOG_IN)
}