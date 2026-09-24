package com.example.karsakov_andr.data.interfaces

import com.example.karsakov_andr.data.model.ProductResponse
import retrofit2.http.GET

interface ProductInterface {
    @GET ("products")
    suspend fun getProducts(): ProductResponse


}