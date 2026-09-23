package com.example.karsakov_andr.data.interfaces

import com.example.karsakov_andr.data.model.ProductResponse
import com.example.karsakov_andr.data.model.Recipe
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ProductInterface {
    @GET ("products")
    suspend fun getproducts(): ProductResponse

    @POST("recipes/add")
    suspend fun createRecipe(@Body recipe: Recipe): Recipe
}