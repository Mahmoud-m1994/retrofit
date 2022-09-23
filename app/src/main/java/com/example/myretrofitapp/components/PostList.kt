package com.example.myretrofitapp.components

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myretrofitapp.PostCard
import com.example.myretrofitapp.models.Post

@Composable
fun PostList(posts: List<Post>) {
    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(8.dp)) {

        items(posts) { post ->
            Row(Modifier.fillMaxWidth()) {
                PostCard(post = post, onClick = { Log.d("cardClicked", "postID = ${post.id}") })
            }
        }
    }
}