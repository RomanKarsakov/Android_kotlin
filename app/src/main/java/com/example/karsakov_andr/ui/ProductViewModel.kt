package com.example.karsakov_andr.ui

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {
    fun fetch(){
        viewModelScope.launch {
            try {
                val productResponse = RetrofitClient.retrofitAPI.getproducts()
                val products = productResponse.products
                for (product in products)
                {
                    Log.d(TAG, "${product}")
                }
            } catch (e: Exception){
                Log.e(TAG, " ${e.message}", e)
            }
        }
    }
}