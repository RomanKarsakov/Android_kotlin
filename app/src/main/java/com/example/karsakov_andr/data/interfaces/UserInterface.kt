package com.example.karsakov_andr.data.interfaces

import com.example.karsakov_andr.data.model.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface UserInterface {
    @GET("users/{id}")
    suspend fun getUserById(@Path ("id") userId: Int): User

    @PUT("users/{id}")
    suspend fun updateUser(@Path ("id") userId: Int, @Body user: User): User
}