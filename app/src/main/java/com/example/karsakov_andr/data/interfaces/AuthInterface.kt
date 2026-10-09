package com.example.karsakov_andr.data.interfaces

import com.example.karsakov_andr.data.model.AuthResponse
import com.example.karsakov_andr.data.model.UserAuth
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthInterface {
    @POST("users/auth-with-password")
    suspend fun authPasswrd(@Body userAuth: UserAuth): AuthResponse

    @GET("todos/records")
    suspend fun getTodos(@Header("Authorization") token: String): AuthResponse
}