package com.example.karsakov_andr.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.karsakov_andr.data.RetrofitClient
import com.example.karsakov_andr.data.TokenManager
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class TodoViewModel(private val tokenManager: TokenManager): ViewModel() {
    fun todofetch () {
        viewModelScope.launch {
                val token =  tokenManager.tokenFlow().first()
                try {
                    val records = RetrofitClient.todoApi.getTodos("${token}")
                    val items = records.items

                    for(item in items)
                    {
                        Log.d("LoginViewModel", "id:${item.id}\n" +
                                "todo:${item.todo}\n" +
                                "completed:${item.completed}\n" +
                                "created:${item.created}\n" +
                                "updated:${item.updated}\n")
                    }
                    Log.d("LoginViewModel", "" +
                            " page:${records.page}\n " +
                            "perPage:${records.perPage}\n totalItems:${records.totalItems}\n " +
                            "totalPages:${records.totalPages}")
            } catch (ex: Exception) {
                Log.e("LoginViewModel", "${ex.message}")
            }
        }
    }
}