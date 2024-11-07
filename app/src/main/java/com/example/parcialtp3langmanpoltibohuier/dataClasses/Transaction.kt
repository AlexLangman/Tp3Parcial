package com.example.parcialtp3langmanpoltibohuier.dataClasses

data class Transaction(
    val transaction_id: String,
    val date: String,
    val description: String,
    val amount: Double,
    val currency: String,
    val type: String,
)
