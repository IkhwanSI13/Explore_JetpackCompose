package com.ikhwankoto.sample_jetpackcompose.layout

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.ikhwankoto.sample_jetpackcompose.ui.theme.Sample_JetpackComposeTheme
import kotlinx.coroutines.launch

/**
 * Sample 5
 * */
@Preview
@Composable
fun Sample5() {
    Sample_JetpackComposeTheme {
        var values = List(1000) { "Hello Android #$it" }
        Scaffold() {
            LazyColumn() {
                items(items = values) { item ->
                    Text(item, modifier = Modifier.padding(8.dp))
//                    ImageListItem(text = item)
                }
            }
        }
    }
}

///

@Composable
fun ImageListItem(context: Context, index: Int) {
    Row(Modifier.clickable {
        Toast.makeText(context, "Click at $index", Toast.LENGTH_SHORT).show()
    }, verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = rememberImagePainter(
                data = "https://developer.android.com/images/brand/Android_Robot.png"
            ),
            contentDescription = "Android Logo",
            modifier = Modifier.size(50.dp)
        )
        Spacer(Modifier.width(10.dp))
        Text("Item #$index", style = MaterialTheme.typography.subtitle1)
    }
}

@Composable
fun ScrollingList(context: Context) {
    val listSize = 100
    // We save the scrolling position with this state
    val scrollState = rememberLazyListState()
    // We save the coroutine scope where our animated scroll will be executed
    val coroutineScope = rememberCoroutineScope()

    Column {
        Row {
            Button(onClick = {
                coroutineScope.launch {
                    // 0 is the first item index
                    scrollState.animateScrollToItem(0)
                }
            }) {
                Text("Scroll to the top")
            }

            Button(onClick = {
                coroutineScope.launch {
                    // listSize - 1 is the last index of the list
                    scrollState.animateScrollToItem(listSize - 1)
                }
            }) {
                Text("Scroll to the end")
            }
        }

        LazyColumn(state = scrollState) {
            items(listSize) {
                ImageListItem(context, it)
            }
        }
    }
}

@Preview
@Composable
fun ScrollingListPreview() {
    ScrollingList(LocalContext.current)
}