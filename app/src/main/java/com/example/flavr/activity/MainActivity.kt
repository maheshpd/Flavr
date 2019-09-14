package com.example.flavr.activity

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.flavr.R
import com.example.flavr.fragment.Categories
import com.example.flavr.fragment.Favorites
import com.example.flavr.fragment.Home
import com.example.flavr.fragment.Profile
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var homeFragment: Home
    lateinit var categories: Categories
    lateinit var favorites: Favorites
    lateinit var profile: Profile

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        //By default open Home Fragment
        homeFragment = Home()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.Main_Container, homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()


        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottomnavigation)
        bottomNavigation.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {

                R.id.home -> {
                    homeFragment = Home()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.Main_Container, homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.recipe -> {
                    categories = Categories()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.Main_Container, categories)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.recipe -> {
                    favorites = Favorites()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.Main_Container, favorites)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.recipe -> {
                    profile = Profile()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.Main_Container, profile)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }

            true
        }

    }
}
