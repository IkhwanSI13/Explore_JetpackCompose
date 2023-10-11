package com.ikhwankoto.sample_jetpackcompose.animation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ikhwankoto.sample_jetpackcompose.ui.theme.Sample_JetpackComposeTheme
import com.ikhwankoto.sample_jetpackcompose.ui.theme.md_theme_light_primary
import com.ikhwankoto.sample_jetpackcompose.ui.theme.md_theme_light_secondary

@Preview(name = "Animation Expanded")
@Composable
fun PreviewAnimationExpanded() {
    Sample_JetpackComposeTheme {
        AnimationExpanded()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AnimationExpanded() {
    var expanded by remember { mutableStateOf<Boolean>(false) }

    TopicRow(expanded = expanded, onClick = {
        expanded = !expanded
    })
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun TopicRow(expanded: Boolean, onClick: () -> Unit) {
    val backgroundColor by animateColorAsState(if (expanded) md_theme_light_primary else md_theme_light_secondary)

    MySpacer(visible = expanded)
    Surface(
        modifier = Modifier.fillMaxWidth(), elevation = 2.dp, onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(backgroundColor)
                .padding(16.dp)
                // This `Column` animates its size when its content changes.
                .animateContentSize(
                    //animationSpec = spring(
                    //    dampingRatio = Spring.DampingRatioNoBouncy,
                    //    stiffness = Spring.StiffnessMedium
                    //)
                )
        ) {
            Row {
                Icon(
                    imageVector = Icons.Default.Info, contentDescription = null
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "title", style = MaterialTheme.typography.body1
                )
            }
            if (expanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Lorem ispum dolar asek ispum dolar asek ispum dolar " + "asek ispum dolar asek ispum dolar asek ispum dolar asek" + " ispum dolar asek ispum dolar asek ispum dolar asek" + " ispum dolar asek ispum dolar asek ispum dolar asek",
                    textAlign = TextAlign.Justify
                )
            }
        }
    }
    MySpacer(visible = expanded)
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MySpacer(visible: Boolean) {
    AnimatedVisibility(visible = visible) {
        Spacer(
            modifier = Modifier
                .height(8.dp)
                .background(Color.Red)
        )
    }
}