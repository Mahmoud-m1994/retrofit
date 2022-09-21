package com.example.myretrofitapp.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myretrofitapp.api.RetrofitInstance
import kotlinx.coroutines.launch

private const val TAG = "MyViewModel"
class MyViewModel : ViewModel() {
    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun getAllPosts() {
        viewModelScope.launch {
            val response = RetrofitInstance.myApi.getAllPosts()
            Log.d(TAG, "getAllPosts: ${response.size}")
        }
    }
}