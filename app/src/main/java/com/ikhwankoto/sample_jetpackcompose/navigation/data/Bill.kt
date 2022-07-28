package com.ikhwankoto.sample_jetpackcompose.navigation.data

import androidx.compose.ui.graphics.Color

data class Bill(
    val name: String,
    val amount: Long,
)

object BillData {
    val bills: List<Bill> = listOf(
        Bill(
            "Name 1",
            15000L,
        ),
        Bill(
            "Name 2",
            14000L,
        ),
        Bill(
            "Name 3",
            15020L,
        ),
        Bill(
            "Name 4",
            15100L,
        ),
        Bill(
            "Name 5",
            10000L,
        ),
    )

    fun getBill(name: String?): Bill {
        return bills.first { it.name == name }
    }
}