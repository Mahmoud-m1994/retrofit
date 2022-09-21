package com.example.myretrofitapp.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
object RetrofitInstance {
    // Lazy make sure that the instance will be created just when It's called
    // This can be helpful to avoid creating an retrofit instance every time a component render
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val myApi: MyApi by lazy {
        retrofit.create(MyApi::class.java)
    }
}