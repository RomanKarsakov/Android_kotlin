package com.example.karsakov_andr.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.karsakov_andr.data.RetrofitClient
import kotlinx.coroutines.launch

class PostViewModel: ViewModel() {
    fun deletepost(id: Int) {
        viewModelScope.launch {
            try {
                val post = RetrofitClient.postApi.deleteById(id)
                Log.d("PostViewModel","id ${post.id} удален - ${post.isDeleted}")
            } catch (e: Exception) {
                Log.e("RetrofitError", e.message.toString())
            }
        }
    }

}