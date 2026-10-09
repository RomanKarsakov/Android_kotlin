package com.example.karsakov_andr.data.interfaces

import com.example.karsakov_andr.data.model.AuthResponse
import com.example.karsakov_andr.data.model.TodosResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface TodoInterface {
    @GET("todos/records")
    suspend fun getTodos(@Header("Authorization") token: String): TodosResponse
}