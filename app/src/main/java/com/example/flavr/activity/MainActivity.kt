package com.example.flavr.activity

import android.os.Bundle
import android.view.Window
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.flavr.R
import com.example.flavr.fragment.Categories
import com.example.flavr.fragment.Favorites
import com.example.flavr.fragment.Home
import com.example.flavr.fragment.Profile
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var homeFragment: Home
    lateinit var categories: Categories
    lateinit var favorites: Favorites
    lateinit var profile: Profile

    val fragment: Fragment = Home()
    private var content: FrameLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomnavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        addFragment(fragment)
    }


    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeIcon -> {
                    val homefragment = Home()
                    addFragment(homefragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.recipe -> {
                    val categoriesfragment = Categories()
                    addFragment(categoriesfragment)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.favourite -> {
                    val favouritefragment = Favorites()
                    addFragment(favouritefragment)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.profile -> {

                    val profilefragment = Profile()
                    addFragment(profilefragment)
                    return@OnNavigationItemSelectedListener true
                }

            }
            false
        }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content, fragment, fragment.javaClass.simpleName)
            .commit()

    }
}
