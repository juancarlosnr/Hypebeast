package com.example.hypebeast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.hypebeast.databinding.ActivityMainBinding
import com.example.hypebeast.ui.home.HomeFragment
import com.example.hypebeast.ui.profile.ProfileFragment
import com.example.hypebeast.ui.sneakers.SneakersFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val navController = findNavController(R.id.fragments)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment, R.id.sneakersFragment, R.id.profileFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)

        bottomNavigationView.setupWithNavController(navController)
    }

}