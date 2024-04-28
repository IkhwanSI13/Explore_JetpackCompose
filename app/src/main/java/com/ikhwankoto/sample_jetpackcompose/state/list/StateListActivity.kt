package com.ikhwankoto.sample_jetpackcompose.state.list

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Cake
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ikhwankoto.sample_jetpackcompose.R

class StateListActivity : ComponentActivity() {

    val viewModel by viewModels<StateListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateListView(
                items = viewModel.noteItems,
                addingState = viewModel.stateAdding,
                onAddRandomItem = viewModel::addItem,
                onAddItem = { item ->
                    viewModel.addItem(item)
                    viewModel.updateAddingState(false)
                },
                onUpdateAddingState = viewModel::updateAddingState
            )
        }
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

@Composable
fun StateListView(
    items: List<NoteItem>,
    addingState: Boolean,
    onAddRandomItem: (NoteItem) -> Unit,
    onAddItem: (NoteItem) -> Unit,
    onUpdateAddingState: (Boolean) -> Unit
) {
    val context = LocalContext.current

    val focusTextField = remember { FocusRequester() }
    val noteTextField = rememberSaveable { mutableStateOf("") }

    Scaffold(
        content = {
            Column(
                modifier = Modifier.padding(it)
            ) {
                TopAppBar(
                    title = {
                        Text(text = "State List")
                    },
                    backgroundColor = colorResource(id = R.color.teal_700),
                    contentColor = Color.White,
                    elevation = 2.dp,
                    actions = {
                        IconButton(onClick = {
                            onClickAddRandom(onAddItem = onAddRandomItem)
                        }) {
                            Icon(Icons.Default.Cake, "")
                        }
                    }
                )
                if (addingState) {
                    Text(
                        text = "Input Note",
                        modifier = Modifier.padding(24.dp, 12.dp, 24.dp),
                        style = TextStyle(fontSize = 18.sp),
                        fontWeight = FontWeight(800)
                    )
                    OutlinedTextField(
                        value = noteTextField.value,
                        onValueChange = { noteTextField.value = it },
                        modifier = Modifier
                            .padding(24.dp, 8.dp, 24.dp)
                            .fillMaxWidth()
                            .focusRequester(focusTextField)
                            .focusable(),
                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(onDone = {
                            onClickAdd(noteTextField, onAddItem, onUpdateAddingState)
                        }),
                    )
                }
                LazyColumn() {
                    items(items = items) { item ->
                        ListNoteAdapter(context = context, item = item)
                    }
                }
            }
        },
        floatingActionButton = {
            if (!addingState)
                FloatingActionButton(
                    onClick = {
                        onUpdateAddingState(true)
//                            focusTextField.requestFocus()
                    }
                ) {
                    Icon(Icons.Filled.Add, "", tint = Color.White)
                }
        }
    )
//    if (addingState)
//        focusTextField.requestFocus()
}

///

fun onClickItem(context: Context, item: NoteItem) {
    Toast.makeText(context, "${item.note} clicked", Toast.LENGTH_SHORT).show()
}

fun onClickAddRandom(onAddItem: (NoteItem) -> Unit) {
    onAddItem(NoteItem(note = "Random note ${(0..100).random()}", icon = R.drawable.ic_umbrella))
}

fun onClickAdd(
    noteTextField: MutableState<String>,
    onAddItem: (NoteItem) -> Unit,
    onUpdateAddingState: (Boolean) -> Unit,
) {
    onAddItem(
        NoteItem(
            note = noteTextField.value,
            icon = R.drawable.ic_bio
        )
    )
    noteTextField.value = ""
    onUpdateAddingState(false)
}

///

@Preview(showBackground = true)
@Composable
fun ListNoteAdapterPreview() {
    ListNoteAdapter(
        context = LocalContext.current,
        item = NoteItem("Random note ${(0..100).random()}")
    )
}

@Preview(showBackground = true, name = "Adding state true")
@Composable
fun StateListViewPreview() {
    val items = listOf(
        NoteItem("Initial note ${(0..10).random()}"),
        NoteItem("Initial note ${(0..10).random()}"),
        NoteItem("Initial note ${(0..10).random()}"),
    )
    StateListView(items, true, {}, {}, {})
}

@Preview(showBackground = true, name = "Adding state false")
@Composable
fun StateListViewPreviewFalse() {
    val items = listOf(
        NoteItem("Initial note ${(0..10).random()}"),
        NoteItem("Initial note ${(0..10).random()}"),
        NoteItem("Initial note ${(0..10).random()}"),
    )
    StateListView(items, false, {}, {}, {})
}