package com.example.hypebeast.ui.onBoarding.screens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.hypebeast.R
import com.example.hypebeast.databinding.FragmentThirdScreenBinding
import com.example.hypebeast.databinding.FragmentViewPagerBinding


class ThirdScreen : Fragment(R.layout.fragment_third_screen) {
    private lateinit var binding: FragmentThirdScreenBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        binding = FragmentThirdScreenBinding.bind(view)

        binding.tvFinish.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_loginFragment)
            onBoardingFinished()
        }
        binding.tvPrevious.setOnClickListener {
            viewPager?.currentItem = 1
        }

    }
   private fun onBoardingFinished(){
      val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
       val editor = sharedPref.edit()
       editor.putBoolean("Finished", true)
       editor.apply()
   }
}