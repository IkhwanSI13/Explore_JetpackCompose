package com.ikhwankoto.sample_jetpackcompose.layout

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ikhwankoto.sample_jetpackcompose.ui.theme.Sample_JetpackComposeTheme

/**
 * Sample 4
 * */
@Preview
@Composable
fun Sample4() {
    Sample_JetpackComposeTheme {
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
        ) { innerPadding ->
            BodyContent()
        }
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