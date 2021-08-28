package com.ikhwankoto.sample_jetpackcompose.state

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Cake
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ikhwankoto.sample_jetpackcompose.R
import com.ikhwankoto.sample_jetpackcompose.ui.theme.Sample_JetpackComposeTheme

class StateListActivity : ComponentActivity() {

    val viewModel by viewModels<StateListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateListView(
                items = viewModel.noteItems,
                onAddItem = viewModel::addItem
            )
        }
    }

}

@Composable
fun StateListView(
    items: List<NoteItem>,
    onAddItem: (NoteItem) -> Unit
) {
    val context = LocalContext.current

    Sample_JetpackComposeTheme {
        Scaffold(
            content = {
                Column {
                    TopAppBar(
                        title = {
                            Text(text = "State List")
                        },
                        backgroundColor = colorResource(id = R.color.teal_700),
                        contentColor = Color.White,
                        elevation = 2.dp,
                        actions = {
                            IconButton(onClick = {
                                onClickAddRandom(onAddItem = onAddItem)
                            }) {
                                Icon(Icons.Default.Cake, "")
                            }
                        }
                    )
                    LazyColumn() {
                        items(items = items) { item ->
                            ListNoteAdapter(context = context, item = item)
                        }
                    }
                }
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {}
                ) {
                    Icon(Icons.Filled.Add, "", tint = Color.White)
                }
            }
        )
    }
}

@Composable
fun ListNoteAdapter(context: Context, item: NoteItem) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable(
                onClick = {
                    onClickItem(context, item)
                },
            )
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp)
    ) {
        Image(
            painterResource(item.icon),
            contentDescription = "",
            Modifier
                .padding(end = 12.dp)
                .size(24.dp)
        )
        Text(
            item.note,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
        )
    }

}

fun onClickItem(context: Context, item: NoteItem) {
    Toast.makeText(context, "${item.note} clicked", Toast.LENGTH_SHORT).show()
}

fun onClickAddRandom(onAddItem: (NoteItem) -> Unit) {
    onAddItem(NoteItem(note = "Random note ${(0..100).random()}", icon = R.drawable.ic_umbrella))
}

///
@Preview(showBackground = true)
@Composable
fun StateListViewPreview() {
    val items = listOf(
        NoteItem("Initial note ${(0..10).random()}"),
        NoteItem("Initial note ${(0..10).random()}"),
        NoteItem("Initial note ${(0..10).random()}"),
    )
    StateListView(items, {})
}

@Preview(showBackground = true)
@Composable
fun ListNoteAdapterPreview() {
    ListNoteAdapter(
        context = LocalContext.current,
        item = NoteItem("Random note ${(0..100).random()}")
    )
}