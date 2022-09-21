package com.example.myretrofitapp.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
class RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            // we need to add converter factory to
            // convert JSON object to Java object
            .build()
    }

    val myApi: MyApi by lazy {
        retrofit.create(MyApi::class.java)
    }
}