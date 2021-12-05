package com.ikhwankoto.sample_jetpackcompose.navigation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    onClickToSearch: () -> Unit = {},
    onClickToBill: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 32.dp)
    ) {
        Text(
            "Home Screen",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(600), textAlign = TextAlign.Center
            ),
            modifier = Modifier.fillMaxWidth(),
        )
        Button(
            onClick = { onClickToSearch() }, modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Go to Search Screen")
        }
        Button(
            onClick = { onClickToBill() }, modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Go to Bill Screen")
        }
    }
}