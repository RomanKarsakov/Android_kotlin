package com.example.karsakov_andr.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.karsakov_andr.data.RetrofitClient
import com.example.karsakov_andr.data.interfaces.UserInterface
import com.example.karsakov_andr.data.model.Hair
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    fun updateUsers() {
        viewModelScope.launch {
            try {
                val user = RetrofitClient.userApi.getUserById(15)
                Log.d("UserViewModel", "$user")
                val newUser = user.copy(
                    firstName = "Ирина",
                    lastName = "Воронова",
                    age = 29,
                    hair = Hair(
                        color = "темные",
                        type = "кудрявые"
                    )
                )
                if (user.id != null) {
                    val updatedUser = RetrofitClient.userApi.updateUser(
                        user.id,
                        newUser
                    )
                    Log.d("UserViewModel", "$updatedUser")
                }
            } catch (e: Exception) {
                Log.e("RetrofitError", e.message.toString())
            }
        }
    }
}