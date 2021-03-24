package com.example.hypebeast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val navController = findNavController(R.id.fragments)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment, R.id.sneakersFragment, R.id.profileFragment))

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when(destination.id){
                R.id.loginFragment -> hideBottomNav()
                R.id.registerFragment -> hideBottomNav()
                R.id.settingsFragment -> hideBottomNav()
                R.id.detailsFragment -> hideBottomNav()
                R.id.homeFragment -> showBottomNav()
                R.id.sneakersFragment -> showBottomNav()
                R.id.profileFragment -> showBottomNav()
            }

        }

        bottomNavigationView.setupWithNavController(navController)
    }

    private fun showBottomNav(){
        val bottomNavigationView  = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.visibility = View.VISIBLE
    }
    private fun hideBottomNav(){
       val bottomNavigationView  = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.visibility = View.GONE
    }

}