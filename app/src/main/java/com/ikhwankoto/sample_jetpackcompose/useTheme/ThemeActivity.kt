package com.ikhwankoto.sample_jetpackcompose.useTheme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ikhwankoto.sample_jetpackcompose.ui.theme.Sample_JetpackComposeTheme

class ThemeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Sample_JetpackComposeTheme {
                ThemeContent()
            }
        }
    }
}

@Composable
fun ThemeContent() {
    val scrollState = rememberScrollState()

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(24.dp)
        ) {
            ThemeColorContent()
            ThemeTextContent()
            ThemeShapeContent()
        }
    }
}

@Composable
fun ThemeColorContent() {
    Text(
        "-- COLOR SECTION --", fontSize = 18.sp, textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(bottom = 18.dp)
    )

    /// Sample 1
    Surface(color = MaterialTheme.colors.primary) {
        Text("1.1 Text color from onPrimary") // default text color is 'onPrimary'
    }
    Surface(color = MaterialTheme.colors.error) {
        Text("1.2 Text color from onError") // default text color is 'onPrimary'
    }

    /// Sample 2
    Surface(
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f),
        contentColor = MaterialTheme.colors.primary,
    ) {
        Text(
            text = "2. Text color 3",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }

    /// Sample 3
    val derivedColor = MaterialTheme.colors.secondaryVariant.copy(alpha = 0.5f)
    Text("3. Text derived color", color = derivedColor) // default text color is 'onPrimary'

    /// Sample 4
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.disabled) {
        Text("4. Text color 4")
    }
}

@Composable
fun ThemeTextContent() {
    Text(
        "-- TEXT SECTION --", fontSize = 18.sp, textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, bottom = 18.dp)
    )

    /// Sample 1
    Text(
        "1.1 MaterialTheme.typography.body1",
        style = MaterialTheme.typography.body1
    )
    Text(
        "1.2 MaterialTheme.typography.h4",
        style = MaterialTheme.typography.h4
    )

    /// Sample 2
    Button(onClick = { }) {
        /// By parent theme
        Text("2.1 This text will use MaterialTheme.typography.button style by default")
    }

    /// Sample 3
    ProvideTextStyle(MaterialTheme.typography.h6) { //set the "current" text style
        Text("3.1 ProvideTextStyle")
    }

    /// Sample 4
    Text(
        text = "4.1 MaterialTheme.typography.h4 Custom",
        style = MaterialTheme.typography.h4.copy(
            fontSize = 18.sp,
            background = MaterialTheme.colors.secondary
        )
    )

    /// Sample 5
    Text(buildAnnotatedString {
        append("5.1 This is some unstyled text\n")
        withStyle(SpanStyle(color = Color.Red)) {
            append("Red text\n")
        }
        withStyle(SpanStyle(fontSize = 24.sp)) {
            append("Large text")
        }
    })

}

@Composable
fun ThemeShapeContent() {
    Text(
        "-- SHAPE SECTION --", fontSize = 18.sp, textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, bottom = 18.dp)
    )

    /// Sample 1
    Button(
        modifier = Modifier.padding(bottom = 4.dp),
        onClick = { }) {
        // Use shapes.small by default
        Text("1.1 Shape default")
    }

    Button(
        modifier = Modifier.padding(bottom = 4.dp),
        onClick = { },
        shape = MaterialTheme.shapes.small
    ) {
        Text("1.2 Shape small")
    }

    Button(
        modifier = Modifier.padding(bottom = 4.dp),
        onClick = { },
        shape = MaterialTheme.shapes.medium
    ) {
        Text("1.3 Shape medium")
    }

    /// Sample 2
    Button(
        modifier = Modifier.padding(bottom = 4.dp),
        onClick = { },
        shape = MaterialTheme.shapes.small.copy(
            bottomStart = CornerSize(12.dp), // overrides small theme style
            bottomEnd = ZeroCornerSize // overrides small theme style
        )
    ) {
        Text("2. Shape small custom")
    }

}

/**
 * PREVIEW
 * */

@Preview(name = "with theme")
@Composable
fun PreviewThemeTextContent() {
    Sample_JetpackComposeTheme {
        ThemeContent()
    }
}

@Preview(name = "without theme")
@Composable
fun PreviewThemeTextContent2() {
    ThemeContent()
}