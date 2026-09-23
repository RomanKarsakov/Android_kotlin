package com.example.karsakov_andr.ui.viewmodel

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.karsakov_andr.data.RetrofitClient
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {
    fun fetch(){
        viewModelScope.launch {
            try {
                val productResponse = RetrofitClient.retrofitAPI.getproducts()
                val products = productResponse.products
                for (product in products)
                {
                    Log.d(ContentValues.TAG, "${product}")
                }
            } catch (e: Exception){
                Log.e(ContentValues.TAG, " ${e.message}", e)
            }
        }
    }
}