package com.example.karsakov_andr.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.karsakov_andr.data.RetrofitClient
import com.example.karsakov_andr.data.model.Recipe
import kotlinx.coroutines.launch

class RecipeViewModel : ViewModel(){
    fun addRecipe(recipe: Recipe) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.retrofitAPI.createRecipe(recipe)

                Log.d(
                    "RecipeLog",
                    "ID: ${response.id} | " +
                            "Название: ${response.name} | " +
                            "Время приготовления: ${response.prepTimeMinutes} | " +
                            "Трудность: ${response.difficulty} | " +
                            "Ингредиенты: ${response.ingredients.joinToString(", ")}"
                )

            } catch (e: Exception) {
                Log.e("RetrofitError", e.message.toString())
            }
        }
    }
}