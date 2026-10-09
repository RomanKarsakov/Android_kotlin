package com.example.karsakov_andr.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.karsakov_andr.data.RetrofitClient
import com.example.karsakov_andr.data.model.UserAuth
import kotlinx.coroutines.launch

class TodosViewModel : ViewModel() {
    fun login (userAuth: UserAuth) {
        viewModelScope.launch {
            try {
                val authUser = RetrofitClient.authApi.authPass(userAuth)
                Log.d("LoginViewModel", "User: ${authUser.token} ${authUser.record}")

                val records = RetrofitClient.todoApi.getTodos("${authUser.token}")

                Log.d("LoginViewModel", "items:${records.items}\n" +
                        " page:${records.page}\n " +
                        "perPage:${records.perPage}\n totalItems:${records.totalItems}\n " +
                        "totalPages:${records.totalPages}")
            } catch (e: Exception) {
                Log.e("RetrofitError", e.message.toString())
            }
        }
    }
}