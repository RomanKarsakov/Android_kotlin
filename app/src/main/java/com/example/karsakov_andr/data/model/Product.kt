package com.example.karsakov_andr.data.model

data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String? = null,
)