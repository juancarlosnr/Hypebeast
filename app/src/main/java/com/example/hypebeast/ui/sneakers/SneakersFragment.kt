package com.example.hypebeast.ui.sneakers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.hypebeast.R
import com.example.hypebeast.core.Resource
import com.example.hypebeast.data.remote.sneakers.SneakersDataSource
import com.example.hypebeast.databinding.FragmentSneakersBinding
import com.example.hypebeast.domain.sneakers.SneakersRepoImpl
import com.example.hypebeast.presentation.sneakers.SneakersViewModel
import com.example.hypebeast.presentation.sneakers.SneakersViewModelFactory
import com.example.hypebeast.ui.home.adapter.HomeAdapter
import com.example.hypebeast.ui.sneakers.adapter.SneakersAdapter


class SneakersFragment : Fragment(R.layout.fragment_sneakers) {

    private lateinit var binding: FragmentSneakersBinding
    private val viewModel by viewModels<SneakersViewModel> {
        SneakersViewModelFactory(SneakersRepoImpl(SneakersDataSource()))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSneakersBinding.bind(view)

        viewModel.fetchLatestSneakers().observe(viewLifecycleOwner, Observer { result ->
            when(result){
                is Resource.Loading ->  {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Sucess -> {
                    binding.progressBar.visibility = View.GONE
                    binding.rvSneakers.adapter = SneakersAdapter(result.data)
                }
                is Resource.Failure ->{
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), "Ocurrio un error ${result.exception}", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}