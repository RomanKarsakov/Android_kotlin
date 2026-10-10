package com.example.karsakov_andr.ui.viewmodel

import android.content.ContentValues
import androidx.compose.runtime.State
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.karsakov_andr.data.RetrofitClient
import com.example.karsakov_andr.data.model.Product
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {
    private val _productsState = mutableStateOf<List<Product>>(emptyList())
    val productsState: State<List<Product>> = _productsState

    init {
        fetch()
    }

    fun fetch(){
        viewModelScope.launch {
            try {
                val productResponse = RetrofitClient.retrofitAPI.getProducts()
                val products = productResponse.products
                _productsState.value = products
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