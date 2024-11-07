package com.example.parcialtp3langmanpoltibohuier

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val drawerState = DrawerState(initialValue = DrawerValue.Closed)


    fun toggleDrawer(
        scope: CoroutineScope,
        drawerState: DrawerState,
    ) {
        scope.launch {
            if (drawerState.isClosed) {
                drawerState.open()
            } else {
                drawerState.close()
            }
        }
    }
}
