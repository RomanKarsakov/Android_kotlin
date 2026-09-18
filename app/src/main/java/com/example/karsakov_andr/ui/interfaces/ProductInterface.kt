package com.example.karsakov_andr.ui.interfaces

import com.example.karsakov_andr.data.ProductResponse
import retrofit2.http.GET

interface ProductInterface {
    @GET ("products")
    suspend fun getproducts(): ProductResponse
}