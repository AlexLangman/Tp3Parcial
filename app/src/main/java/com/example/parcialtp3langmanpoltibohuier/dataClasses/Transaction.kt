package com.example.parcialtp3langmanpoltibohuier.dataClasses

import com.example.parcialtp3langmanpoltibohuier.ui.components.enums.TransactionType
import java.time.LocalDate
/*
data class Transaction(
    val date: LocalDate,
    val type: TransactionType,
    val aut: Int,
    val amount : Float,
)*/

// TODO: Los parametros que ingresaron no se corresponden con la vista del Figma.
data class Transaction(
    val transaction_id: String,
    val date: String,
    val description: String,
    val amount: Double,
    val currency: String,
    val type: String
)
