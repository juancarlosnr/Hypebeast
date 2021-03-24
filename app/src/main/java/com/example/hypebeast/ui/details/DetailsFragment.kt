package com.example.hypebeast.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.hypebeast.R
import com.example.hypebeast.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment(R.layout.fragment_details) {

    private lateinit var binding: FragmentDetailsBinding
    private val args by navArgs<DetailsFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailsBinding.bind(view)

        Glide.with(requireContext()).load("${args.sneakersPicture}").centerCrop().into(binding.ivMain)
        binding.tvTitle.text = args.sneakersTitle
        binding.tvRelease.text = args.sneakersReleasedate
        binding.tvDescription.text = args.sneakersDescription
        binding.tvReleaseprice.text = args.sneakersReleaseprice
        binding.tvResellprice.text = args.sneakersResellprice


    }
}