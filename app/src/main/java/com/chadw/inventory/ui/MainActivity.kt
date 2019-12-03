package com.chadw.inventory.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chadw.inventory.R
import kotlinx.android.synthetic.main.activity_main.*
import com.chadw.inventory.ui.DisplayActivity as DisplayActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logInButton.setOnClickListener {
            startActivity(Intent(this,DisplayActivity::class.java))
        }
    }
}
