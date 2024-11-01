package com.example.parcialtp3langmanpoltibohuier.ui.components.samples

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.parcialtp3langmanpoltibohuier.ui.screens.myAccount.Transaction
import com.example.parcialtp3langmanpoltibohuier.ui.screens.myAccount.TransactionsType
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
val sampleTransactions = listOf(
        Transaction(LocalDate.of(2020,3,19), TransactionsType.TRANSFERENCIA, 394991, 2000.00),
        Transaction(LocalDate.of(2020,3,19), TransactionsType.PAGO_DE_SERVICIO, 394991, -400.00),
        Transaction(LocalDate.of(2020,3,19), TransactionsType.TRANSFERENCIA, 394991, 1000.00),
        Transaction(LocalDate.of(2020,3,19), TransactionsType.RECARGA_SUBE, 394991, 100.00),
        Transaction(LocalDate.of(2020,3,19), TransactionsType.TRANSFERENCIA, 394991, 1000.00),
        Transaction(LocalDate.of(2020,3,19), TransactionsType.TRANSFERENCIA, 394991, 1000.00),
    )