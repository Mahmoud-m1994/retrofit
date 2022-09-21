package com.example.myretrofitapp.api

import com.example.myretrofitapp.models.Post
import retrofit2.http.GET

interface MyApi {
    @GET("posts")
    suspend fun getAllPosts(): List<Post>
}