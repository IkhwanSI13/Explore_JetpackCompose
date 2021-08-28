package com.ikhwankoto.sample_jetpackcompose.state

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
import com.ikhwankoto.sample_jetpackcompose.ui.theme.Sample_JetpackComposeTheme

class FormActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Sample_JetpackComposeTheme {
                FormActivityView()
            }
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
                SwitchView()
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

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TextFieldView() {
    val keyboardController = LocalSoftwareKeyboardController.current

    val textStateNormal = rememberSaveable { mutableStateOf("") }
    val textStateType1 = rememberSaveable { mutableStateOf("") }
    val textStateType2 = rememberSaveable { mutableStateOf("") }

    Text(
        text = "TextField",
        modifier = Modifier.padding(top = 24.dp),
        style = TextStyle(fontSize = 18.sp),
        fontWeight = FontWeight(800)
    )
    TextField(
        value = textStateNormal.value,
        onValueChange = { textStateNormal.value = it },
        modifier = Modifier
            .padding(top = 12.dp)
            .fillMaxWidth(),
        label = { Text("TextField Normal") }
    )
    OutlinedTextField(
        value = textStateNormal.value,
        onValueChange = { textStateNormal.value = it },
        modifier = Modifier
            .padding(top = 12.dp)
            .fillMaxWidth(),
        label = { Text("OutlinedTextField Normal") }
    )
    BasicTextField(
        value = textStateNormal.value,
        onValueChange = { textStateNormal.value = it },
        modifier = Modifier
            .padding(top = 12.dp)
            .fillMaxWidth(),
    )
    TextField(
        value = textStateType1.value,
        onValueChange = { textStateType1.value = it },
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = {
            //Todo something else
            keyboardController?.hide()
        }), modifier = Modifier
            .padding(top = 12.dp)
//                        .height(72.dp)
            .fillMaxWidth(),
        label = { Text(text = "TextField Type1", color = Color.White) },
        textStyle = TextStyle(color = Color.White),
        shape = RoundedCornerShape(24.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = colorResource(id = R.color.purple_200),
        ),
        leadingIcon = {
            Image(
                painterResource(R.drawable.ic_cart),
                contentDescription = "",
                Modifier
                    .size(24.dp)
            )
        }
    )
    TextField(
        value = textStateType2.value,
        onValueChange = { textStateType2.value = it },
        modifier = Modifier
            .padding(top = 12.dp)
            .fillMaxWidth(),
        isError = true,
        label = { Text(text = "TextField Type2") },
        trailingIcon = {
            Image(
                painterResource(R.drawable.ic_umbrella),
                contentDescription = "",
                Modifier
                    .size(24.dp)
            )
        }
    )

    ///
    Text(
        text = "Custom TextField (With another layout)",
        modifier = Modifier.padding(top = 24.dp),
        style = TextStyle(fontSize = 18.sp),
        fontWeight = FontWeight(800)
    )
    CustomTextField(
        modifier = Modifier
            .padding(top = 12.dp)
            .fillMaxWidth()
            .background(
                color = Color(0xffb9b9b9),
                shape = RoundedCornerShape(percent = 10)
            )
            .padding(horizontal = 12.dp, vertical = 10.dp),
        leadingIcon = { Icon(Icons.Default.Email, "Email") },
        trailingIcon = { Icon(Icons.Filled.Email, "Email") },
        paddingLeadingIconEnd = 10.dp,
        paddingTrailingIconStart = 10.dp
    )
    CustomTextField(
        modifier = Modifier
            .padding(top = 12.dp)
            .fillMaxWidth()
            .background(
                color = Color(0xffb9b9b9),
                shape = CircleShape
            )
            .padding(horizontal = 12.dp, vertical = 10.dp),
        leadingIcon = { Icon(Icons.Default.Email, "Email") },
        trailingIcon = { Icon(Icons.Filled.Email, "Email") },
        paddingLeadingIconEnd = 10.dp,
        paddingTrailingIconStart = 10.dp
    )
    CustomTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
            .background(
                brush = Brush.horizontalGradient(
                    listOf(Color(0xffa18cd1), Color(0xfffbc2eb)),
                    startX = 0.0f,
                    endX = 1000.0f,
                    tileMode = TileMode.Repeated
                ),
                shape = CircleShape
            )
            .padding(horizontal = 12.dp, vertical = 10.dp),
        leadingIcon = { Icon(Icons.Default.Email, "Email") },
        paddingLeadingIconEnd = 10.dp
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

@Composable
fun SwitchView() {
    val checkedState = remember { mutableStateOf(true) }

    Text(
        text = "Switch",
        modifier = Modifier.padding(top = 24.dp),
        style = TextStyle(fontSize = 18.sp),
        fontWeight = FontWeight(800)
    )
    Switch(
        checked = checkedState.value,
        onCheckedChange = { checkedState.value = it }
    )
}

///

@Composable
private fun CustomTextField(
    modifier: Modifier = Modifier,
    paddingLeadingIconEnd: Dp = 0.dp,
    paddingTrailingIconStart: Dp = 0.dp,
    leadingIcon: (@Composable() () -> Unit)? = null,
    trailingIcon: (@Composable() () -> Unit)? = null
) {
//    val state = savedInstanceState (saver = TextFieldValue.Saver) { TextFieldValue() }
    val state = remember { mutableStateOf(TextFieldValue()) }

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        if (leadingIcon != null) {
            leadingIcon()
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(start = paddingLeadingIconEnd, end = paddingTrailingIconStart)
        ) {
            BasicTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.value,
                onValueChange = { state.value = it }
            )
            if (state.value.text.isEmpty()) {
                Text(
                    text = "Placeholder"
                )
            }
        }
        if (trailingIcon != null) {
            trailingIcon()
        }
    }
}

///
@Preview(showBackground = true)
@Composable
fun FormActivityPreview() {
    Sample_JetpackComposeTheme {
        FormActivityView()
    }
}