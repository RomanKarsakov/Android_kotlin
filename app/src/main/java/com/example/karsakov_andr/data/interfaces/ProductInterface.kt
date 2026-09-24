package com.example.karsakov_andr.data.interfaces

import com.example.karsakov_andr.data.model.ProductResponse
<<<<<<< HEAD
import com.example.karsakov_andr.data.model.Recipe
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ProductInterface {
    @GET ("products")
    suspend fun getproducts(): ProductResponse

    @POST("recipes/add")
    suspend fun createRecipe(@Body recipe: Recipe): Recipe
=======
import retrofit2.http.GET

interface ProductInterface {
    @GET ("products")
    suspend fun getProducts(): ProductResponse


>>>>>>> 59d9868 (pr02 and pr01)
}