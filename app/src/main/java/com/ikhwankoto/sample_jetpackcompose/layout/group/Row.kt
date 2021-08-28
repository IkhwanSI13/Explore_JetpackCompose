package com.ikhwankoto.sample_jetpackcompose.layout.group

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
fun MyRow() {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Text(
            "Red", modifier = Modifier
                .background(Color.Red)
                .weight(1f),
            textAlign = TextAlign.Center
        )
        Text(
            "Green", modifier = Modifier
                .background(Color.Green)
                .weight(2f)
                .height(45.dp),
            textAlign = TextAlign.Center
        )
        Text(
            "Blue", modifier = Modifier
                .background(Color.Blue)
                .weight(2f)
                .height(30.dp)
                .align(alignment = Alignment.CenterVertically),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RowPreview() {
    Sample_JetpackComposeTheme {
        MyRow()
    }
}