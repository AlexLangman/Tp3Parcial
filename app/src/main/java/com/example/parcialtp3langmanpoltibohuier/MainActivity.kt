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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.parcialtp3langmanpoltibohuier.ui.screens.myProfile.DarkModeButton
import com.example.parcialtp3langmanpoltibohuier.ui.theme.ParcialTP3LangmanPoltiBohuierTheme
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.firestore

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        enableEdgeToEdge()
        setContent {
            val themeViewModel: ThemeViewModel = viewModel() // Instancia del ViewModel

            ParcialTP3LangmanPoltiBohuierTheme(themeViewModel = themeViewModel) {
                Scaffold (
                    content = {
                        Column {
                            MainScaffold(navController = rememberNavController())
                            DarkModeButton(themeViewModel = themeViewModel) // Botón de cambio de tema
                        }
                    }
                )
            }
        }
    }
}
