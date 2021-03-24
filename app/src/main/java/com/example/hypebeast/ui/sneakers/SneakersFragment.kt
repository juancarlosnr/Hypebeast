package com.example.hypebeast.ui.sneakers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hypebeast.R
import com.example.hypebeast.core.Result
import com.example.hypebeast.data.remote.sneakers.SneakersDataSource
import com.example.hypebeast.databinding.FragmentSneakersBinding
import com.example.hypebeast.domain.sneakers.SneakersRepoImpl
import com.example.hypebeast.presentation.sneakers.SneakersViewModel
import com.example.hypebeast.presentation.sneakers.SneakersViewModelFactory
import com.example.hypebeast.ui.sneakers.adapter.SneakersAdapter


class SneakersFragment : Fragment(R.layout.fragment_sneakers) {

    private lateinit var binding: FragmentSneakersBinding
    private var gridLayoutManager: GridLayoutManager? = null
    private val viewModel by viewModels<SneakersViewModel> {
        SneakersViewModelFactory(SneakersRepoImpl(SneakersDataSource()))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSneakersBinding.bind(view)
        gridLayoutManager = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)

        viewModel.fetchLatestSneakers().observe(viewLifecycleOwner, Observer { result ->
            when(result){
                is Result.Loading ->  {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Result.Sucess -> {
                    binding.progressBar.visibility = View.GONE
                    binding.rvSneakers.layoutManager = gridLayoutManager
                    binding.rvSneakers.setHasFixedSize(true)
                    binding.rvSneakers.adapter = SneakersAdapter(result.data)
                }
                is Result.Failure ->{
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), "Ocurrio un error ${result.exception}", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}