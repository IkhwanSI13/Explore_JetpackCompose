package com.ikhwankoto.sample_jetpackcompose.layout.view

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ScaffoldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldView()
        }
    }
}

@Preview
@Composable
fun ScaffoldView() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "LayoutsCodelab")
                },
                actions = {
                    IconButton(onClick = {
                        Log.e("Ikhwan", "IconButton click")
                    }) {
                        Icon(Icons.Filled.Call, contentDescription = null)
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar() {
                Text(text = "Bottom bar", modifier = Modifier.padding(8.dp))
            }
        }
    ) { padding ->
        BodyContent(
            modifier = Modifier.padding(padding)
        )
    }
}

//modifier membuat lebih reusable, jika misal menggunakan param
// modifier dengan tambahan padding, maka akan menambahkan padding
// lagi ke layout
@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(8.dp)) {
        Text(text = "Hi there!")
        Text(text = "Thanks for going through the Layouts codelab")
    }
}