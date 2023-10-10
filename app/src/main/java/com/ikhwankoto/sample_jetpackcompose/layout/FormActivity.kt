package com.ikhwankoto.sample_jetpackcompose.layout

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ikhwankoto.sample_jetpackcompose.R
import com.ikhwankoto.sample_jetpackcompose.layout.view.TextFieldView
import com.ikhwankoto.sample_jetpackcompose.ui.theme.Sample_JetpackComposeTheme

class FormActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FormActivityView()
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun FormActivityView() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Form")
                },
                backgroundColor = colorResource(id = R.color.teal_700),
                contentColor = Color.White,
                elevation = 2.dp,
            )
        },
        content = {
            Column(
                Modifier
                    .padding(horizontal = 24.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Log.e("Ikhwan", "FormActivityView column run")
                TextFieldView()
                ///
                DropdownView()
                CheckBoxView()
                RadioView()
                SliderView()
                SnackBarView()
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

@Composable
fun DropdownView() {
    var expanded = remember { mutableStateOf(false) }
    val items = listOf("A", "B", "C", "D", "E", "F")
    val disabledValue = "B"
    var selectedIndex = remember { mutableStateOf(0) }

    Text(
        text = "Dropdown",
        modifier = Modifier.padding(top = 24.dp),
        style = TextStyle(fontSize = 18.sp),
        fontWeight = FontWeight(800)
    )
    Text(
        items[selectedIndex.value],
        color = Color.White,
        modifier = Modifier
            .padding(top = 12.dp)
            .background(
                Color.Gray
            )
            .clickable(onClick = { expanded.value = true })
            .padding(vertical = 12.dp, horizontal = 18.dp)
            .fillMaxWidth()
    )
    DropdownMenu(
        expanded = expanded.value,
        onDismissRequest = { expanded.value = false },
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Color.DarkGray
            )
    ) {
        items.forEachIndexed { index, value ->
            DropdownMenuItem(onClick = {
                if (value != disabledValue)
                    selectedIndex.value = index
                expanded.value = false
            }) {
                val disabledText = if (value == disabledValue) {
                    " (Disabled)"
                } else {
                    ""
                }
                Text(text = value + disabledText, color = Color.White)
            }
        }
    }
}

@Composable
fun CheckBoxView() {
    val checkedState = remember { mutableStateOf(true) }

    Log.e("Ikhwan", "CheckBoxView run")
    Text(
        text = "Checkbox",
        modifier = Modifier.padding(top = 24.dp),
        style = TextStyle(fontSize = 18.sp),
        fontWeight = FontWeight(800)
    )
    Row(
        modifier = Modifier
            .padding(top = 12.dp)
    ) {
        Log.e("Ikhwan", "CheckBoxView run inside row")
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it },
            modifier = Modifier.padding(end = 18.dp)
        )
        Log.e("Ikhwan", "CheckBoxView run inside row before text")
        val disabledText = if (checkedState.value) {
            " Checked"
        } else {
            " Unchecked"
        }
        Text(text = "Checkbox " + disabledText, modifier = Modifier.fillMaxWidth())
    }
    Log.e("Ikhwan", "CheckBoxView run end")
}

@Composable
fun RadioView() {
    val radioOptions = listOf("A", "B", "C")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1]) }

    Text(
        text = "Radio Button",
        modifier = Modifier.padding(top = 24.dp),
        style = TextStyle(fontSize = 18.sp),
        fontWeight = FontWeight(800)
    )
    Column {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)
                        }
                    )
                    .padding(horizontal = 16.dp)
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) }
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.body1.merge(),
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}

@Composable
fun SliderView() {
    val sliderPosition = remember { mutableStateOf(0f) }

    Text(
        text = "Slider",
        modifier = Modifier.padding(top = 24.dp),
        style = TextStyle(fontSize = 18.sp),
        fontWeight = FontWeight(800)
    )
    Text(text = "Slider position: ${sliderPosition.value.toString()}")
    Slider(value = sliderPosition.value, onValueChange = { sliderPosition.value = it })
}

@Composable
fun SnackBarView() {
    val snackbarVisibleState = remember { mutableStateOf(false) }

    Text(
        text = "Snackbar",
        modifier = Modifier.padding(top = 24.dp),
        style = TextStyle(fontSize = 18.sp),
        fontWeight = FontWeight(800)
    )
    Button(onClick = { snackbarVisibleState.value = !snackbarVisibleState.value }) {
        if (snackbarVisibleState.value) {
            Text("Hide Snackbar")
        } else {
            Text("Show Snackbar")
        }
    }
    if (snackbarVisibleState.value) {
        Snackbar(

            action = {
                Button(onClick = {}) {
                    Text("MyAction")
                }
            },
            modifier = Modifier.padding(8.dp)
        ) { Text(text = "This is a snackbar!") }
    }
}

///
@Preview(showBackground = true)
@Composable
fun FormActivityPreview() {
//    Sample_JetpackComposeTheme {
    FormActivityView()
//    }
}