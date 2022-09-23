package com.example.myretrofitapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myretrofitapp.components.PostList
import com.example.myretrofitapp.ui.theme.MyRetrofitAppTheme
import com.example.myretrofitapp.viewmodels.MyViewModel

class MainActivity : ComponentActivity() {
    val postViewModel by viewModels<MyViewModel>()
    val isLoading = mutableStateOf(true)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            if (isLoading.value) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 32.dp)
                ) {

                    LoadingIndecator()
                }
            }
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 32.dp)
            ) {
                LaunchedEffect(postViewModel, block = {
                    postViewModel.getpostList()
                })
                Text(
                    text = "All posts",
                    modifier = Modifier
                        .testTag("test"),
                    color = Color.Gray,
                    fontSize = 30.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.Serif,
                )
                if (postViewModel.postList.isNotEmpty()) {
                    PostList(
                        posts = postViewModel.postList
                    )
                    isLoading.value = false
                }
            }
        }
    }
}

@Composable
fun LoadingIndecator() {
    Text(text = "Fetching data", fontFamily = FontFamily.Monospace)
    LinearProgressIndicator(color = Color.Gray, modifier = Modifier.padding(top = 16.dp))
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyRetrofitAppTheme {
        Greeting("Android")
    }
}