package com.example.karsakov_andr.data.interfaces

import com.example.karsakov_andr.data.model.Post
import retrofit2.http.DELETE
import retrofit2.http.Path

interface PostInterface {
    @DELETE("posts/{id}")
    suspend fun deleteById(@Path("id") postId: Int): Post
}