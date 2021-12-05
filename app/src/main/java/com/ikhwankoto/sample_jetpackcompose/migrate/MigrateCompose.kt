package com.ikhwankoto.sample_jetpackcompose.migrate

import android.content.Context
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.ikhwankoto.sample_jetpackcompose.R

@Preview
@Composable
fun PreviewMigrateCompose() {
    MigrateCompose()
}

@Composable
fun MigrateCompose() {
    var context = LocalContext.current

    Scaffold(backgroundColor = colorResource(id = R.color.purple_200)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Compose World", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
            Button(
                shape = RoundedCornerShape(12.dp),
                onClick = {
                    Toast.makeText(context, "Hello from compose world", Toast.LENGTH_SHORT)
                        .show()
                },
            ) {
                Text("Click Me")
            }
            AndroidView(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxSize(),
                factory = { context: Context ->
                    val view = LayoutInflater.from(context)
                        .inflate(R.layout.activity_migrate2, null, false)
                    view.findViewById<Button>(R.id.btn_xml2).setOnClickListener {
                        Toast.makeText(
                            context,
                            "Hello from XML world inside Compose world",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    view // return the view
                },
                update = {}
            )
        }

    }
}