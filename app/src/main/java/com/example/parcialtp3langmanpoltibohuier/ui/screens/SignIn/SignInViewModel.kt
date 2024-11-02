package com.example.parcialtp3langmanpoltibohuier.ui.screens.SignIn

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcialtp3langmanpoltibohuier.dataClasses.LoginDataClass
import com.example.parcialtp3langmanpoltibohuier.dataClasses.LoginRequest
import com.example.parcialtp3langmanpoltibohuier.helpers.retrofit.RetrofitServiceFactory
import kotlinx.coroutines.launch

class SignInViewModel: ViewModel() {
    private val ERROR_LOGIN_IN = "Error login in"
    private val retrofitService = RetrofitServiceFactory.makeRetrofitService()
    public val login = MutableLiveData<LoginDataClass>() //Response de login

    fun login(body:LoginRequest) {
        try {
            viewModelScope.launch {
                val loginResponse: LoginDataClass = retrofitService.login(body)
                login.value = loginResponse
            }
        } catch (e: Exception) {
            throw RuntimeException("Error: ${ERROR_LOGIN_IN}")
        }
    }
}