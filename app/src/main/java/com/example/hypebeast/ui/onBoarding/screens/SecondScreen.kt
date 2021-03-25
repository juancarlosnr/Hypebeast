package com.example.hypebeast.ui.onBoarding.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.hypebeast.R
import com.example.hypebeast.databinding.FragmentFirstScreenBinding
import com.example.hypebeast.databinding.FragmentSecondBinding
import com.example.hypebeast.databinding.FragmentThirdScreenBinding


class SecondScreen : Fragment(R.layout.fragment_second) {
    private lateinit var binding: FragmentSecondBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        binding = FragmentSecondBinding.bind(view)

        binding.tvNext.setOnClickListener {
            viewPager?.currentItem = 2
        }
        binding.tvPrevious.setOnClickListener {
            viewPager?.currentItem = 0
        }
    }
}