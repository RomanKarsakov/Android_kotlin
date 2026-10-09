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
                val authuser = RetrofitClient.authApi.authPasswrd(userAuth)


            } catch (e: Exception) {
                Log.e("RetrofitError", e.message.toString())
            }
        }
    }
}