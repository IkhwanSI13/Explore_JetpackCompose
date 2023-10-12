package com.ikhwankoto.sample_jetpackcompose

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ikhwankoto.sample_jetpackcompose.animation.AnimationActivity
import com.ikhwankoto.sample_jetpackcompose.layout.FormActivity
import com.ikhwankoto.sample_jetpackcompose.layout.view.LazyColumnImageActivity
import com.ikhwankoto.sample_jetpackcompose.layout.view.LazyColumnTextActivity
import com.ikhwankoto.sample_jetpackcompose.layout.view.ScaffoldActivity
import com.ikhwankoto.sample_jetpackcompose.layout.view.SwitchActivity
import com.ikhwankoto.sample_jetpackcompose.layout.view.TextFieldActivity
import com.ikhwankoto.sample_jetpackcompose.layout.view.lazyColumnObject.LazyColumnObjectActivity
import com.ikhwankoto.sample_jetpackcompose.navigation.NavigationActivity
import com.ikhwankoto.sample_jetpackcompose.state.game.GameActivity
import com.ikhwankoto.sample_jetpackcompose.state.list.StateListActivity
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

        val btnLayoutLazyColumnImage = findViewById<Button>(R.id.btn_layout_lazy_column_image)
        btnLayoutLazyColumnImage.setOnClickListener {
            startActivity(Intent(this, LazyColumnImageActivity::class.java))
        }

        val btnLayoutLazyColumnObject = findViewById<Button>(R.id.btn_layout_lazy_column_object)
        btnLayoutLazyColumnObject.setOnClickListener {
            startActivity(Intent(this, LazyColumnObjectActivity::class.java))
        }

        val btnLayoutLazyColumnText = findViewById<Button>(R.id.btn_layout_lazy_column_text)
        btnLayoutLazyColumnText.setOnClickListener {
            startActivity(Intent(this, LazyColumnTextActivity::class.java))
        }

        val btnLayoutTextField = findViewById<Button>(R.id.btn_layout_text_field)
        btnLayoutTextField.setOnClickListener {
            startActivity(Intent(this, TextFieldActivity::class.java))
        }

        val btnLayoutScaffold = findViewById<Button>(R.id.btn_layout_scaffold)
        btnLayoutScaffold.setOnClickListener {
            startActivity(Intent(this, ScaffoldActivity::class.java))
        }

        val btnLayoutSwitch = findViewById<Button>(R.id.btn_layout_switch)
        btnLayoutSwitch.setOnClickListener {
            startActivity(Intent(this, SwitchActivity::class.java))
        }

        val btnLayoutForm = findViewById<Button>(R.id.btn_layout_form)
        btnLayoutForm.setOnClickListener {
            startActivity(Intent(this, FormActivity::class.java))
        }

        val btnNavigation = findViewById<Button>(R.id.btn_navigation)
        btnNavigation.setOnClickListener {
            startActivity(Intent(this, NavigationActivity::class.java))
        }

        val btnStateList = findViewById<Button>(R.id.btn_state_list)
        btnStateList.setOnClickListener {
            startActivity(Intent(this, StateListActivity::class.java))
        }

        val btnStateGame = findViewById<Button>(R.id.btn_state_game)
        btnStateGame.setOnClickListener {
            startActivity(Intent(this, GameActivity::class.java))
        }
    }
}