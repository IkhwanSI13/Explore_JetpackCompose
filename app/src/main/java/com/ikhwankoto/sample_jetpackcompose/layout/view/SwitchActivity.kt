package com.ikhwankoto.sample_jetpackcompose.layout.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ikhwankoto.sample_jetpackcompose.R


class SwitchActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SwitchView()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SwitchView() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Switch")
                },
                backgroundColor = colorResource(id = R.color.teal_700),
                contentColor = Color.White,
                elevation = 2.dp,
            )
        },
        content = {
            Column(
                Modifier
                    .padding(24.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                SwitchSample()
                Button(
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .height(45.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(id = R.color.teal_200),
                        contentColor = Color.White,
                    ),
                    onClick = {}
                ) {
                    Text("Hit to Validate")
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun SwitchSample() {
    val checkedState = remember { mutableStateOf(true) }

    Switch(
        checked = checkedState.value,
        onCheckedChange = { checkedState.value = it }
    )
}