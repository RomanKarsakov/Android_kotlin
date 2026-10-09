package com.example.karsakov_andr.data.interfaces

import com.example.karsakov_andr.data.model.AuthResponse
import com.example.karsakov_andr.data.model.UserAuth
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthInterface {
    @POST("users/auth-with-password")
    suspend fun authPass(@Body userAuth: UserAuth): AuthResponse


}