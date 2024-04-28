package com.ikhwankoto.sample_jetpackcompose.layout.group

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ikhwankoto.sample_jetpackcompose.ui.theme.Sample_JetpackComposeTheme

@Composable
fun MyColumn() {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
    ) {
        Text("Left text", Modifier.background(Color.Yellow))
        Text(
            "Center Text",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .background(Color.Yellow)
        )
        Text(
            "Right Text", modifier = Modifier
                .align(Alignment.End)
                .background(Color.Yellow)
        )
        Text(
            "Lagi", modifier = Modifier
                .padding(vertical = 12.dp)
                .background(color = Color.Gray)
                .padding(12.dp)
                .background(color = Color.Green)
                .width(60.dp)
                .height(150.dp),
            textAlign = TextAlign.Center
        )
        Text(
            "Green", modifier = Modifier
                .background(Color.Green)
                .fillMaxWidth()
                .weight(1f),
            textAlign = TextAlign.Center
        )
        Text(
            "Red", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .weight(1f),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ColumnPreview() {
    Sample_JetpackComposeTheme {
        MyColumn()
    }
}