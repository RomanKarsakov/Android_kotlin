package com.example.karsakov_andr.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.karsakov_andr.data.RetrofitClient
import com.example.karsakov_andr.data.TokenManager
import com.example.karsakov_andr.data.model.UserAuth
import kotlinx.coroutines.launch

class LoginViewModel(private val tokenManager: TokenManager,
                     private val todoViewModel: TodoViewModel) : ViewModel() {
    fun login (userAuth: UserAuth) {
        viewModelScope.launch {
            try {
                val authUser = RetrofitClient.authApi.authPass(userAuth)
                Log.d("LoginViewModel", "User: ${authUser.token} ${authUser.record}")
                authUser.token?.let{
                    writeToken(it)
                    todoViewModel.todofetch()
                }
            } catch (e: Exception) {
                Log.e("RetrofitError", e.message.toString())
            }
        }
    }
    fun writeToken(token: String) {
        viewModelScope.launch {
            tokenManager.saveToken(token)
        }
    }
}