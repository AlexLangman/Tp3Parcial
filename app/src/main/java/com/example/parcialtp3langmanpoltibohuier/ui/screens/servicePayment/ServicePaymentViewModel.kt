package com.example.parcialtp3langmanpoltibohuier.ui.screens.servicePayment

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ServicePaymentViewModel : ViewModel() {
    private val _isMainDialogOpen = mutableStateOf(false)
    val isMainDialogOpen: State<Boolean> get() = _isMainDialogOpen

    private val _isConfirmationDialogOpen = mutableStateOf(false)
    val isConfirmationDialogOpen: State<Boolean> get() = _isConfirmationDialogOpen

    fun openMainDialog() {
        _isMainDialogOpen.value = true
    }

    fun closeMainDialog() {
        _isMainDialogOpen.value = false
    }

    fun openConfirmationDialog() {
        _isMainDialogOpen.value = false
        _isConfirmationDialogOpen.value = true
    }

    fun closeConfirmationDialog() {
        _isConfirmationDialogOpen.value = false
    }
}