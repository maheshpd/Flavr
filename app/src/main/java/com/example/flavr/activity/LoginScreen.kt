package com.example.flavr.activity

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import com.example.flavr.KCustomToast
import com.example.flavr.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login_screen.*

class LoginScreen : AppCompatActivity() {

    private lateinit var mAuth : FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        mAuth = FirebaseAuth.getInstance()


        login_btn.setOnClickListener {

            val email = login_email_edt.text.toString().trim()
            val password = login_password_edt.text.toString().trim()

            if (email.isEmpty()) {
                KCustomToast.infoToast(this,"Email Required",Gravity.CENTER)
                login_email_edt.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                KCustomToast.infoToast(this,"Valid Email Required",Gravity.CENTER)
                login_email_edt.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty() || password.length < 6) {
                KCustomToast.infoToast(this,"6 char password required",Gravity.CENTER)
                login_password_edt.requestFocus()
                return@setOnClickListener
            }

            loginUser(email,password)

        }


    }

    private fun loginUser(email: String, password: String) {


    }


}
