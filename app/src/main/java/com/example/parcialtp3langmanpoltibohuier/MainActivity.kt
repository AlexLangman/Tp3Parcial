package com.example.parcialtp3langmanpoltibohuier

import MainScaffold
import ThemeViewModel
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.parcialtp3langmanpoltibohuier.ui.components.buttons.SwitchThemeComponent
import com.example.parcialtp3langmanpoltibohuier.ui.theme.ParcialTP3LangmanPoltiBohuierTheme
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()
            val currentBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = currentBackStackEntry?.destination?.route
            val mainViewModel: MainViewModel = viewModel()
            val themeViewModel: ThemeViewModel = viewModel() // Instancia del ViewModel
            ParcialTP3LangmanPoltiBohuierTheme(themeViewModel = themeViewModel) {
                Scaffold (

                    content = {
                        Column {
                            MainScaffold(navController = rememberNavController(), mainViewModel = mainViewModel)
                            SwitchThemeComponent(themeViewModel = themeViewModel) // Botón de cambio de tema
                        }
                    }
                )
            }
        }
    }
}
