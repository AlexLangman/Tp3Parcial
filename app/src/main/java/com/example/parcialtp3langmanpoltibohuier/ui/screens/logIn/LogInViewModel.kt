package com.example.parcialtp3langmanpoltibohuier.ui.screens.logIn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.parcialtp3langmanpoltibohuier.dataClasses.LoginRequest
import com.example.parcialtp3langmanpoltibohuier.helpers.retrofit.RetrofitServiceFactory
import com.example.parcialtp3langmanpoltibohuier.ui.navigation.AppRoutes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class LogInViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState
    private val retrofitService = RetrofitServiceFactory.makeRetrofitService()

    fun onUsernameChange(newUsername: String) {
        _uiState.value = _uiState.value.copy(username = newUsername)
    }

    fun onPasswordChange(newPassword: String) {
        _uiState.value = _uiState.value.copy(password = newPassword)
    }

    fun onLoginClick(navController: NavHostController) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, errorMessage = null)

            try {
                val loginRequest =
                    LoginRequest(
                        username = _uiState.value.username,
                        password = _uiState.value.password,
                    )
                val response = retrofitService.login(loginRequest)

                _uiState.value = _uiState.value.copy(isLoading = false)
                println("Token recibido: ${response.token}")

                navController.navigate(AppRoutes.HOME) {
                    popUpTo(AppRoutes.LOG_IN) { inclusive = true }
                }
            } catch (e: HttpException) {
                _uiState.value =
                    _uiState.value.copy(
                        isLoading = false,
                        errorMessage = "Credenciales inválidas. Inténtalo de nuevo.",
                    )
            } catch (e: IOException) {
                _uiState.value =
                    _uiState.value.copy(
                        isLoading = false,
                        errorMessage = "Error de red. Verifica tu conexión.",
                    )
            } catch (e: Exception) {
                _uiState.value =
                    _uiState.value.copy(
                        isLoading = false,
                        errorMessage = "Error desconocido. Inténtalo más tarde.",
                    )
            }
        }
    }
}

data class LoginUiState(
    val username: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)
