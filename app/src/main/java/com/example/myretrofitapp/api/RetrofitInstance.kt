package com.example.myretrofitapp.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
class RetrofitInstance {
    // Lazy make sure that the instance will be created just when It's called
    // This can be helpful to avoid creating an retrofit instance every time a component render
    private val retrofit: MyApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(MyApi::class.java)
    }
}