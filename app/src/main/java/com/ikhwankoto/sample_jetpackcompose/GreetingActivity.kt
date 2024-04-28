package com.ikhwankoto.sample_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ikhwankoto.sample_jetpackcompose.ui.theme.Sample_JetpackComposeTheme

class GreetingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyScreenContent()
                Greeting("Android")
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    Sample_JetpackComposeTheme {
        Surface(color = Color.Yellow) {
            content()
        }
    }

    /**
     * Surface seperti relative layout / stack di flutter
     * karena jika terdapat dua widget, maka hasilnya bertumpuk
     * MyApp {
    Greeting("Android sss")
    MyScreenContent()
    }
     *
     * */
}

@Composable
fun MyScreenContent(names: List<String> = List(5) { "Hello Android #$it" }) {
    val counterState = remember { mutableIntStateOf(0) }

    Column(modifier = Modifier.fillMaxHeight()) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(24.dp)),
            contentScale = ContentScale.Crop
        )
        NameList(names, Modifier.weight(1f))
        Counter(count = counterState.value, updateCount = { newCount ->
            counterState.value = newCount
        })
    }
}

@Composable
fun NameList(names: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(items = names) { name ->
            Greeting(name = name)
            Divider(color = Color.Black)
        }
    }
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(
        onClick = { updateCount(count + 1) }, colors = ButtonDefaults.buttonColors(
            backgroundColor = if (count > 5) Color.Green else Color.White
        )
    ) {
        Text("I've been clicked $count times")
    }
}

@Composable
fun Greeting(name: String) {
    var isSelected by remember { mutableStateOf(false) }
    val backgroundColor by animateColorAsState(if (isSelected) Color.Red else Color.Transparent)

    Text(
        text = "Hello $name!",
        modifier = Modifier
            .padding(24.dp)
            .background(color = backgroundColor)
            .clickable(onClick = { isSelected = !isSelected })
    )
//    Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
}

/**
 * Preview just show on Android Studio.
 * The real one to execute to real device inside
 * onCreate methode, setContent function
 * */
@Preview()
@Composable
fun PreviewFinal() {
    MyApp {
        
        MyScreenContent()
        Greeting("Android")
    }
}

@Preview()
@Composable
fun PreviewMyScreenContent() {
    MyScreenContent()
}

@Preview(showBackground = true, name = "Text preview")
@Composable
fun PreviewGreeting() {
    Greeting("Android")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    Counter(count = 2, updateCount = { newCount ->

    })
}