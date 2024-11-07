package com.example.parcialtp3langmanpoltibohuier.dataClasses

data class Payment(
    val user_id: String,
    val balance: Float,
    val bank_account: BankAccount,
    val transactions: Transactions,
)

data class BankAccount(
    val bank_name: String,
    val account_type: String,
    val cvu: String,
    val alias: String,
    val currency: String,
)

data class Transactions(
    // Primer array
    val credit_card_transactions: List<Transaction>,
    // Segundo array
    val bank_account_transactions: List<Transaction>,
)
