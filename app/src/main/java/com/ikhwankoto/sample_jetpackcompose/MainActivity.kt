package com.ikhwankoto.sample_jetpackcompose

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ikhwankoto.sample_jetpackcompose.animation.AnimationActivity
import com.ikhwankoto.sample_jetpackcompose.layout.FormActivity
import com.ikhwankoto.sample_jetpackcompose.layout.view.TextFieldActivity
import com.ikhwankoto.sample_jetpackcompose.navigation.NavigationActivity
import com.ikhwankoto.sample_jetpackcompose.state.StateListActivity
import com.ikhwankoto.sample_jetpackcompose.useTheme.ThemeActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMain = findViewById<Button>(R.id.btn_main)
        btnMain.setOnClickListener {
            startActivity(Intent(this, GreetingActivity::class.java))
        }

        val btnTheme = findViewById<Button>(R.id.btn_theme)
        btnTheme.setOnClickListener {
            startActivity(Intent(this, ThemeActivity::class.java))
        }

        val btnAnimation = findViewById<Button>(R.id.btn_animation)
        btnAnimation.setOnClickListener {
            startActivity(Intent(this, AnimationActivity::class.java))
        }

        val btnLayoutForm = findViewById<Button>(R.id.btn_layout_form)
        btnLayoutForm.setOnClickListener {
            startActivity(Intent(this, FormActivity::class.java))
        }

        val btnLayoutTextField = findViewById<Button>(R.id.btn_layout_text_field)
        btnLayoutTextField.setOnClickListener {
            startActivity(Intent(this, TextFieldActivity::class.java))
        }

        val btnNavigation = findViewById<Button>(R.id.btn_navigation)
        btnNavigation.setOnClickListener {
            startActivity(Intent(this, NavigationActivity::class.java))
        }

        val btnStateList = findViewById<Button>(R.id.btn_state_list)
        btnStateList.setOnClickListener {
            startActivity(Intent(this, StateListActivity::class.java))
        }
    }
}