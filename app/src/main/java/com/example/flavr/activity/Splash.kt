package com.example.flavr.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.flavr.R
import com.google.firebase.auth.FirebaseAuth

class Splash : AppCompatActivity() {

//    private var mDelayHandler: Handler? = null
//    private val SPLASH_DELAY: Long = 3000 //3 second
//
//    private lateinit var mAuth: FirebaseAuth
//
//    internal val mRunnable: Runnable = Runnable {
//        if (isFinishing) {
//
//        }else {
//
//        }
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        setContentView(R.layout.activity_splash)

//        //Initialize the Handler
//        mDelayHandler= Handler()

        //Navigate with delay
//        mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)
        Handler().postDelayed({
            if (FirebaseAuth.getInstance().currentUser == null) {
                val intent = Intent(applicationContext, OptionScreen::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 3000)
    }

//    override fun onDestroy() {
//        if (mDelayHandler != null) {
//            mDelayHandler?.removeCallbacks(mRunnable)
//        }
//
//        super.onDestroy()
//    }


}
