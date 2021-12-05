package com.ikhwankoto.sample_jetpackcompose.navigation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ikhwankoto.sample_jetpackcompose.R
import com.ikhwankoto.sample_jetpackcompose.navigation.data.Bill

@Composable
fun BillsScreen(
    onClickToHome: () -> Unit = {},
    bills: List<Bill>,
    onClickToDetail: (Bill) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 32.dp)
    ) {
        Text(
            "Bills Screen",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(600), textAlign = TextAlign.Center
            ),
            modifier = Modifier.fillMaxWidth(),
        )
        Button(
            onClick = { onClickToHome() }, modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 24.dp)
        ) {
            Text("Go to Home Screen")
        }
        LazyColumn {
            items(items = bills) { item ->
                Text(item.name, modifier = Modifier
                    .padding(bottom = 8.dp)
                    .clickable {
                        onClickToDetail(item)
                    }
                    .background(color = colorResource(id = R.color.teal_200))
                    .padding(vertical = 12.dp, horizontal = 18.dp)
                    .fillMaxWidth()
                )
            }
        }
    }
}