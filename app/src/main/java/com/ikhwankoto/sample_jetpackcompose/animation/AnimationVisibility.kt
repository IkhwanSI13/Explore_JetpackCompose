package com.ikhwankoto.sample_jetpackcompose.animation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cake
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ikhwankoto.sample_jetpackcompose.ui.theme.Sample_JetpackComposeTheme

@Preview(name = "Animation Visibilty")
@Composable
fun PreviewAnimationVisibility() {
    Sample_JetpackComposeTheme {
        AnimationVisibility()
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimationVisibility() {
    var showing by remember { mutableStateOf<Boolean>(false) }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { showing = !showing },
        elevation = 2.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Cake,
                contentDescription = null
            )
            AnimatedVisibility(visible = !showing) {
                Text(
                    text = "Click card to hide this text",
                    modifier = Modifier.padding(start = 18.dp)
                )
            }
        }
    }

}