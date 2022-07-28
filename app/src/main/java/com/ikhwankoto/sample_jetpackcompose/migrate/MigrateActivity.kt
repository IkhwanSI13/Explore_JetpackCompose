package com.ikhwankoto.sample_jetpackcompose.migrate

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Surface
import androidx.compose.ui.platform.ComposeView
import com.ikhwankoto.sample_jetpackcompose.R

class MigrateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_migrate)

        findViewById<Button>(R.id.btn_xml).setOnClickListener {
            Toast.makeText(this, "Hello from XML World", Toast.LENGTH_SHORT).show()
        }

        /**
         * use latest
         * androidx.appcompat:appcompat:1.3.0
         * */
        findViewById<ComposeView>(R.id.compose_view).setContent {
            Surface { MigrateCompose() }
        }
    }

}