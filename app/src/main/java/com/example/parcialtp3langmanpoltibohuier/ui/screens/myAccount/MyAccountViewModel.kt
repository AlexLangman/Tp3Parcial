package com.example.parcialtp3langmanpoltibohuier.ui.screens.myAccount

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.parcialtp3langmanpoltibohuier.dataClasses.Payment
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson

class MyAccountViewModel: ViewModel() {
    val payments = MutableLiveData<List<Payment>>()
    private val firebaseFirestore = FirebaseFirestore.getInstance()
    private val paymentsCollection = firebaseFirestore.collection("payments")

    fun fetchPayments() {
        paymentsCollection.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val paymentsList = ArrayList<Payment>()
                val gson = Gson()

                for (document in task.result.documents) {
                    val dataJson = document.getString("data") // Obtiene el JSON como String
                    if (dataJson != null) {
                        val payment = gson.fromJson(dataJson, Payment::class.java)
                        paymentsList.add(payment)
                    }
                }

                if (paymentsList.isNotEmpty()) {
                    payments.value = paymentsList
                } else {
                    Log.d("Firestore", "No se encontraron pagos en la colección.")
                }
            } else {
                Log.e("FirestoreError", "Error al obtener pagos: ${task.exception}")
            }
        }
    }
}