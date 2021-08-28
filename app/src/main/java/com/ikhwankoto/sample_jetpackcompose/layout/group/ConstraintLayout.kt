package com.ikhwankoto.sample_jetpackcompose.layout.group

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.ikhwankoto.sample_jetpackcompose.ui.theme.Sample_JetpackComposeTheme

@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout {
        val (buttonId, textId) = createRefs()

        Button(
            onClick = { /* Do something */ },
            modifier = Modifier.constrainAs(buttonId) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        ) {
            Text("Button")
        }

        Text("Text", Modifier.constrainAs(textId) {
            top.linkTo(buttonId.bottom, margin = 16.dp)
            centerHorizontallyTo(parent)
//            end.linkTo(buttonId.end)
        })
    }
}

@Preview(showBackground = true)
@Composable
fun ConstraintLayoutContentPreview() {
    Sample_JetpackComposeTheme {
        ConstraintLayoutContent()
    }
}

@Composable
fun ConstraintLayoutContentExample2() {
    ConstraintLayout {
        val (button1, button2, text1) = createRefs()

        Button(
            onClick = { /* Do something */ },
            modifier = Modifier.constrainAs(button1) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        ) {
            Text("Button 1")
        }

        Text("Text", Modifier.constrainAs(text1) {
            top.linkTo(button1.bottom, margin = 16.dp)
            centerAround(button1.end)
        })

        val barrier = createEndBarrier(button1, text1)
        Button(
            onClick = { /* Do something */ },
            modifier = Modifier.constrainAs(button2) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(barrier)
            }
        ) {
            Text("Button 2")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConstraintLayoutContentExample2Preview() {
    Sample_JetpackComposeTheme {
        ConstraintLayoutContentExample2()
    }
}

@Composable
fun LargeConstraintLayout() {
    ConstraintLayout (modifier = Modifier.fillMaxWidth()){
        val text = createRef()
        val guideline = createGuidelineFromStart(fraction = 0.5f)
        Text(
            "This is a very very very very very very very long text",
            Modifier.constrainAs(text) {
                linkTo(start = guideline, end = parent.end)
                //Ngewrap kebawah
                width = Dimension.preferredWrapContent
//                 width = Dimension.preferredWrapContent.atLeast(120.dp)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LargeConstraintLayoutPreview() {
    Sample_JetpackComposeTheme {
        LargeConstraintLayout()
    }
}


@Composable
fun DecoupledConstraintLayout() {
    BoxWithConstraints {
        val constraints = if (maxWidth < maxHeight) {
            decoupledConstraints(margin = 16.dp) // Portrait constraints
        } else {
            decoupledConstraints(margin = 32.dp) // Landscape constraints
        }

        ConstraintLayout(constraints) {
            Button(
                onClick = { /* Do something */ },
                modifier = Modifier.layoutId("button")
            ) {
                Text("Button")
            }

            Text("Text", Modifier.layoutId("text"))
        }
    }
}

private fun decoupledConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val button = createRefFor("button")
        val text = createRefFor("text")

        constrain(button) {
            top.linkTo(parent.top, margin = margin)
        }
        constrain(text) {
            top.linkTo(button.bottom, margin)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DecoupledConstraintLayoutPreview() {
    Sample_JetpackComposeTheme {
        DecoupledConstraintLayout()
    }
}
