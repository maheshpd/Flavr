package com.example.flavr.activity

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import com.example.flavr.KCustomToast
import com.example.flavr.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up_screen.*

class SignUpScreen : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var dialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_screen)

        mAuth = FirebaseAuth.getInstance()
        dialog = ProgressDialog(this)

        signup_btn.setOnClickListener {


            val username = signup_username_edt.text.toString().trim()
            val email = signup_email_edt.text.toString().trim()
            val password = signup_password_edt.text.toString().trim()

            if (username.isEmpty()) {
                KCustomToast.infoToast(this, "User name required", Gravity.CENTER)
                signup_username_edt.requestFocus()
                return@setOnClickListener
            }

            if (email.isEmpty()) {
                KCustomToast.infoToast(this, "Email required", Gravity.CENTER)
                signup_email_edt.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                KCustomToast.infoToast(this, "Valied email required",Gravity.CENTER)
                signup_email_edt.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty() || password.length < 6) {
                KCustomToast.infoToast(this, "6 char password", Gravity.CENTER)
                signup_email_edt.requestFocus()
                return@setOnClickListener
            }

            registerUser(username, email, password)

        }

        signup_back.setOnClickListener {
            onBackPressed()
        }

    }

    private fun registerUser(username: String, email: String, password: String) {
        dialog.setMessage("Please wait...")
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    dialog.dismiss()
                    val intent = Intent(this, MainActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    }
                    startActivity(intent)

                } else {
                    dialog.dismiss()
                    task.exception?.message?.let {
                        KCustomToast.infoToast(this, it, Gravity.CENTER)
                    }

                }
            }
    }
}
