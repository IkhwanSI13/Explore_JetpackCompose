package com.ikhwankoto.sample_jetpackcompose.layout.view

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ikhwankoto.sample_jetpackcompose.ui.theme.Sample_JetpackComposeTheme

/**
 * Sample 2
 * */
@Preview
@Composable
fun Sample2() {
    Sample_JetpackComposeTheme {
        Button(
            shape = RoundedCornerShape(12.dp),
            enabled = false,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Red,
                contentColor = Color.White,
                disabledBackgroundColor = Color.Gray,
                disabledContentColor = Color.DarkGray
            ),
            onClick = {}
        ) {
            Text("asd")
        }
    }
}