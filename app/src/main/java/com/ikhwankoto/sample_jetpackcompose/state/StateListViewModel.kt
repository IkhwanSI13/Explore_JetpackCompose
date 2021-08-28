package com.ikhwankoto.sample_jetpackcompose.state

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class StateListViewModel : ViewModel() {

    var noteItems = mutableStateListOf<NoteItem>()
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

}