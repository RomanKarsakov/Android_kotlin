package com.example.karsakov_andr.data.model

data class Recipe(
    val id: Int? = null,
    val name: String,
    val ingredients: List<String>,
    val instructions: List<String>,
    val prepTimeMinutes: Int,
    val difficulty: String
)
