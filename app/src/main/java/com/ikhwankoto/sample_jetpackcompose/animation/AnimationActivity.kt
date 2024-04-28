package com.ikhwankoto.sample_jetpackcompose.animation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ikhwankoto.sample_jetpackcompose.ui.theme.Sample_JetpackComposeTheme

class AnimationActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Content()
        }
    }
}

@Composable
fun Content() {
    val scrollState = rememberScrollState()

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(24.dp)
        ) {
            ContentTitle(
                title = "Sample 1", desc =
                "1. Tab indicator\n2. Color change"
            )
            AnimationTab()
            ContentTitle(
                title = "Sample 2", desc =
                "1. Loading state"
            )
            AnimationLoading()
            ContentTitle(
                title = "Sample 3", desc =
                "1. Expanded"
            )
            AnimationExpanded()
            ContentTitle(
                title = "Sample 4", desc =
                "1. Swipe"
            )
            AnimationSwipe()
            ContentTitle(
                title = "Sample 5", desc =
                "1. Visibility"
            )
            AnimationVisibility()
        }
    }
}

@Composable
fun ContentTitle(title: String, desc: String) {
    Text(
        title,
        Modifier
            .padding(top = 24.dp), style = TextStyle(fontSize = 18.sp)
    )
    Text(
        desc, Modifier
            .padding(bottom = 12.dp), style = TextStyle(fontSize = 14.sp)
    )
}

@Preview(name = "Animation")
@Composable
fun PreviewContent() {
    Sample_JetpackComposeTheme {
        Content()
    }
}
