package com.example.flavr

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login_screen.*

class LoginScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        login_btn.setOnClickListener {

            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            KCustomToast.infoToast(this, "Some error", Gravity.CENTER)
        }


    }





}
