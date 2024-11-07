package com.example.parcialtp3langmanpoltibohuier.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcialtp3langmanpoltibohuier.dataClasses.UserDataClass
import com.example.parcialtp3langmanpoltibohuier.helpers.retrofit.RetrofitServiceFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val ERROR_GETTING_INFO = "Error getting user info"
    private val retrofitService = RetrofitServiceFactory.makeRetrofitService()

    private val _userInfo = MutableStateFlow<UserDataClass?>(null)
    val userInfo: StateFlow<UserDataClass?> get() = _userInfo

    private val _loading = MutableStateFlow<Boolean>(false)
    val loading: StateFlow<Boolean> get() = _loading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> get() = _error

    fun getUserById(userId: Int) {
        viewModelScope.launch {
            _loading.value = true
            try {
                val userResponse: UserDataClass = retrofitService.getUserById(userId)
                _userInfo.value = userResponse
                _error.value = null
            } catch (e: Exception) {
                _error.value = ERROR_GETTING_INFO
            } finally {
                _loading.value = false
            }
        }
    }
}
