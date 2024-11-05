package com.example.parcialtp3langmanpoltibohuier

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _isDialogOpen = mutableStateOf(false)
    val isDialogOpen: State<Boolean> get() = _isDialogOpen

    private val _isDrawerOpen = mutableStateOf(false)
    val isDrawerOpen: State<Boolean> get() = _isDrawerOpen

    fun toggleDialog() {
        _isDialogOpen.value = !_isDialogOpen.value
    }

    fun toggleDrawer() {
        _isDrawerOpen.value = !_isDrawerOpen.value
    }
}