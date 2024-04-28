package com.ikhwankoto.sample_jetpackcompose.layout.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ikhwankoto.sample_jetpackcompose.R

class TextFieldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextFieldView()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TextFieldView() {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = stringResource(R.string.textField))
            },
            backgroundColor = colorResource(id = R.color.teal_700),
            contentColor = Color.White,
            elevation = 2.dp,
        )
    }, content = {
        Column(
            Modifier
                .padding(it)
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState())
        ) {
            TextFieldSample()
            Button(modifier = Modifier
                .padding(top = 24.dp)
                .height(45.dp)
                .fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.teal_200),
                    contentColor = Color.White,
                ),
                onClick = {}) {
                Text("Hit to Validate")
            }
        }
    })
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TextFieldSample() {
    val keyboardController = LocalSoftwareKeyboardController.current

    val textStateNormal = rememberSaveable { mutableStateOf("") }
    val textStateNormalOutlined = remember { mutableStateOf("Default") }
    val textStateType1 = rememberSaveable { mutableStateOf("") }
    val textStateType2 = rememberSaveable { mutableStateOf("") }

    TextField(
        value = textStateNormal.value,
        onValueChange = { textStateNormal.value = it },
        modifier = Modifier
            .padding(top = 12.dp)
            .fillMaxWidth(),
        label = { Text("TextField Normal") },
        singleLine = true
    )
    OutlinedTextField(value = textStateNormalOutlined.value,
        onValueChange = { textStateNormalOutlined.value = it },
        modifier = Modifier
            .padding(top = 12.dp)
            .fillMaxWidth(),
        label = { Text("OutlinedTextField Normal") })
    BasicTextField(
        value = textStateNormal.value,
        onValueChange = { textStateNormal.value = it },
        modifier = Modifier
            .padding(top = 12.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    )
    TextField(value = textStateType1.value,
        onValueChange = { textStateType1.value = it },
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = {
            //Todo something else
            keyboardController?.hide()
        }),
        modifier = Modifier
            .padding(top = 12.dp)
            //.height(72.dp)
            .fillMaxWidth(),
        label = { Text(text = "TextField Type1", color = Color.White) },
        textStyle = TextStyle(color = Color.White),
        shape = RoundedCornerShape(24.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = colorResource(id = R.color.purple_200),
        ),
        leadingIcon = {
            Image(
                painterResource(R.drawable.ic_cart), contentDescription = "", Modifier.size(24.dp)
            )
        })
    TextField(value = textStateType2.value,
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
                Modifier.size(24.dp)
            )
        })
    Custom2TextField(label = R.string.textfield_custom_2, leadingIcon = R.drawable.ic_umbrella)

    ///
    Text(
        text = "Custom TextField (With another layout)",
        modifier = Modifier.padding(top = 32.dp),
        style = TextStyle(fontSize = 16.sp),
        fontWeight = FontWeight(800)
    )
    CustomTextField(
        modifier = Modifier
            .padding(top = 12.dp)
            .fillMaxWidth()
            .background(
                color = Color(0xffb9b9b9), shape = RoundedCornerShape(percent = 10)
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
                color = Color(0xffb9b9b9), shape = CircleShape
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
                ), shape = CircleShape
            )
            .padding(horizontal = 12.dp, vertical = 10.dp),
        leadingIcon = { Icon(Icons.Default.Email, "Email") },
        paddingLeadingIconEnd = 10.dp
    )
}

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
            BasicTextField(modifier = Modifier.fillMaxWidth(),
                value = state.value,
                onValueChange = { state.value = it })
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

@Composable
private fun Custom2TextField(
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
) {
    val textStateNormal = rememberSaveable { mutableStateOf("") }

    TextField(
        value = textStateNormal.value,
        onValueChange = { textStateNormal.value = it },
        modifier = Modifier
            .padding(top = 12.dp)
            .fillMaxWidth(),
        label = { Text(stringResource(label)) },
        leadingIcon = { Icon(painter = painterResource(id = leadingIcon), null) },
    )
}