package com.ikhwankoto.sample_jetpackcompose.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class StateListViewModel : ViewModel() {

    //MutableState<T> similar to MutableLiveData<T>, but integrated with the compose runtime.

    //You declare a MutableState object in a composable three ways:
    //    val state = remember { mutableStateOf(default) }
    //    var value by remember { mutableStateOf(default) }
    //    val (value, setValue) = remember { mutableStateOf(default) }

    var noteItems = mutableStateListOf<NoteItem>()
        private set

    var stateAdding by mutableStateOf(false)
        private set

    init {
        noteItems.add(NoteItem("Initial note ${(0..10).random()}"))
        noteItems.add(NoteItem("Initial note ${(0..10).random()}"))
        noteItems.add(NoteItem("Initial note ${(0..10).random()}"))
    }

    fun addItem(item: NoteItem) {
        noteItems.add(item)
    }

    fun removeItem(item: NoteItem) {
        noteItems.remove(item)
    }

    ///
    fun updateAddingState(value: Boolean) {
        stateAdding = value
    }

    fun add(item: NoteItem) {
        noteItems.remove(item)
    }

}