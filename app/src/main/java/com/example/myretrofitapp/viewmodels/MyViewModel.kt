package com.example.myretrofitapp.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myretrofitapp.api.RetrofitInstance
import com.example.myretrofitapp.models.Post
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    private val _postList = mutableStateListOf<Post>()
    var errorMessage: String by mutableStateOf("")
    val postList: List<Post>
        get() = _postList

    fun getpostList() {
        viewModelScope.launch {
            val apiService = RetrofitInstance.myApi
            try {
                _postList.clear()
                _postList.addAll(apiService.getAllPosts())

            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}