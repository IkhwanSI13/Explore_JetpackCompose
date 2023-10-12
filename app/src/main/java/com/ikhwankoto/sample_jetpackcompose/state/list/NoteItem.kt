package com.ikhwankoto.sample_jetpackcompose.state.list

import com.ikhwankoto.sample_jetpackcompose.R
import java.util.*

data class NoteItem(
    val note: String,
    val icon: Int = R.drawable.ic_android,
    // since the user may generate identical tasks, give them each a unique ID
    val id: UUID = UUID.randomUUID()
)