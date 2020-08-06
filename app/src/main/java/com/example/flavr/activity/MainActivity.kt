package com.example.flavr.activity

import android.os.Bundle
import android.view.Window
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.flavr.R
import com.example.flavr.fragment.Categories
import com.example.flavr.fragment.Favorites
import com.example.flavr.fragment.Home
import com.example.flavr.fragment.Profile
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var homeFragment: Home
    lateinit var categories: Categories
    lateinit var favorites: Favorites
    lateinit var profile: Profile

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    val fragment: Fragment = Home()
    private var content: FrameLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.mainView)

        bottomnavigation.setupWithNavController(navController)

    }

}
