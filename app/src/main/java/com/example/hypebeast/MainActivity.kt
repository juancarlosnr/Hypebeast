package com.example.hypebeast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.hypebeast.databinding.ActivityMainBinding
import com.example.hypebeast.ui.home.HomeFragment
import com.example.hypebeast.ui.profile.ProfileFragment
import com.example.hypebeast.ui.sneakers.SneakersFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val homeFragment = HomeFragment()
        val sneakersFragment = SneakersFragment()
        val profileFragment = ProfileFragment()

        makeCurrentFragment(homeFragment)
        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> makeCurrentFragment(homeFragment)
                R.id.ic_calendar -> makeCurrentFragment(sneakersFragment)
                R.id.ic_profile -> makeCurrentFragment(profileFragment)
            }
            true
        }


    }
    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}