package com.ikhwankoto.sample_jetpackcompose.layout.group

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ikhwankoto.sample_jetpackcompose.R
import com.ikhwankoto.sample_jetpackcompose.ui.theme.Sample_JetpackComposeTheme

@Composable
fun MyItem() {
    Row(
        modifier = Modifier
            .background(color = Color(0xFFA3E7FC))
            .padding(12.dp)
            .background(color = Color.DarkGray)
            .clickable { }
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painterResource(R.drawable.ic_android),
            contentDescription = "",
            Modifier
                .padding(end = 12.dp)
                .size(24.dp)
        )
        Column {
            Text(
                "Title",
                style = TextStyle(
                    fontSize = 16.sp
                ),
            )
            Text(
                "Lorem ipsum dolor si amet ipsum dolor si amet ipsum dolor si amet",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.grey),
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    Sample_JetpackComposeTheme {
        MyItem()
    }
}

///
@Composable
fun MyItemSlotBased(
    content: @Composable () -> Unit,
) {
    Row(
        modifier = Modifier
            .background(color = Color(0xFFA3E7FC))
            .padding(12.dp)
            .background(color = Color.DarkGray)
            .clickable { }
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painterResource(R.drawable.ic_android),
            contentDescription = "",
            Modifier
                .padding(end = 12.dp)
                .size(24.dp)
        )
        content()
    }
}

@Composable
fun MyContent() {
    Column {
        Text(
            "Title from MyContent",
            style = TextStyle(
                fontSize = 16.sp
            ),
        )
        Text(
            "Lorem ipsum dolor si amet ipsum dolor si amet ipsum dolor si amet",
            style = TextStyle(
                fontSize = 14.sp,
                color = colorResource(id = R.color.grey),
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ItemPreviewSlotBased() {
    Sample_JetpackComposeTheme {
        MyItemSlotBased(content = {
            MyContent()
        })
    }
}