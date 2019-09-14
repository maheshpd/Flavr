package com.example.flavr.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.flavr.R
import kotlinx.android.synthetic.main.activity_optionscreen.*

class OptionScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        setContentView(R.layout.activity_optionscreen)

        loginBtn.setOnClickListener {
            var intent = Intent(this, LoginScreen::class.java)
            startActivity(intent)
        }

        signupBtn.setOnClickListener {
            var intent = Intent(this, SignUpScreen::class.java)
            startActivity(intent)
        }
    }
}
