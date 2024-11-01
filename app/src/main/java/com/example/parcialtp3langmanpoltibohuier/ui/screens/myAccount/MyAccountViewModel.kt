package com.example.parcialtp3langmanpoltibohuier.ui.screens.MyAccount

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.parcialtp3langmanpoltibohuier.dataClasses.Payment
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject

class MyAccountViewModel: ViewModel() {
    public val payments = MutableLiveData<List<Payment>>()
    private val firebaseFirestore = FirebaseFirestore.getInstance()
    private val paymentsCollection = firebaseFirestore.collection("payments")

    fun fetchPayments(){
        paymentsCollection.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val paymentsList = ArrayList<Payment>()
                for (item in task.result){
                    val pay = item.toObject(Payment::class.java)
                    paymentsList.add(pay)
                }

                if (paymentsList.isNotEmpty()){
                    payments.value = paymentsList
                }
            }
        }
    }
}