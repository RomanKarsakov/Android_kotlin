package com.example.karsakov_andr.data

import com.example.karsakov_andr.data.interfaces.PostInterface
import com.example.karsakov_andr.data.interfaces.ProductInterface
import com.example.karsakov_andr.data.interfaces.RecipeInterface
import com.example.karsakov_andr.data.interfaces.UserInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.InetSocketAddress
import java.net.Proxy

object RetrofitClient {
    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("10.207.106.59", 3128))

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .proxy(proxy)
        .build()
    val retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitAPI: ProductInterface = retrofit.create(ProductInterface::class.java)
    val recipeAPI: RecipeInterface = retrofit.create(RecipeInterface::class.java)
    val userApi: UserInterface = retrofit.create(UserInterface::class.java)
    val postApi: PostInterface = retrofit.create(PostInterface::class.java)
    }