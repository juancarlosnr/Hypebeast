package com.example.hypebeast.ui.onBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hypebeast.R
import com.example.hypebeast.databinding.FragmentProfileBinding
import com.example.hypebeast.databinding.FragmentViewPagerBinding
import com.example.hypebeast.ui.onBoarding.screens.FirstScreen
import com.example.hypebeast.ui.onBoarding.screens.SecondScreen
import com.example.hypebeast.ui.onBoarding.screens.ThirdScreen


class ViewPagerFragment : Fragment(R.layout.fragment_view_pager) {
    private lateinit var binding: FragmentViewPagerBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentViewPagerBinding.bind(view)

        val fragmentList = arrayListOf<Fragment>(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen()
        )
        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.viewPager.adapter = adapter


    }
}