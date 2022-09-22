package com.example.myretrofitapp


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.myretrofitapp.models.Post


private var numberOfShowedItem = 1

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PostCard(
    post: Post,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        onClick = onClick,
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text("UserId is  ${post.userId}")
            Text("PostId is  ${post.id}")
            Text(post.title, fontFamily = FontFamily.Monospace, color = Color.Gray)
        }
    }
}


private fun getNumberOfClickMore(number: Int): Int {
    val rest = if (number > 0) number % 10 else 0
    numberOfShowedItem += if (rest == 0) {
        number / 10 + 1
    } else number / 10 + 1

    return numberOfShowedItem
}
