package com.example.flavr.fragment


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.flavr.R
import com.example.flavr.activity.OptionScreen
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_profile.*

/**
 * A simple [Fragment] subclass.
 */
class Profile : Fragment() {

    private lateinit var mAuth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        mAuth = FirebaseAuth.getInstance()

        signout_btn.setOnClickListener {
            mAuth.signOut()

            val intent = Intent(context, OptionScreen::class.java)
            startActivity(intent)
        }

        return view
    }


}
