package com.ikhwankoto.sample_jetpackcompose.layout.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class LazyColumnTextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnTextView()
        }
    }
}

@Preview
@Composable
fun LazyColumnTextView() {
    val values = List(1000) { "Hello Android #$it" }

    Scaffold() {
        LazyColumn() {
            items(items = values) { item ->
                Text(item, modifier = Modifier.padding(8.dp))
            }
        }
    }
}