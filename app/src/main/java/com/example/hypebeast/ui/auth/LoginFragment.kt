package com.example.hypebeast.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.hypebeast.R
import com.example.hypebeast.core.Result
import com.example.hypebeast.data.remote.auth.AuthDataSource
import com.example.hypebeast.databinding.FragmentLoginBinding
import com.example.hypebeast.domain.auth.AuthRepoImpl
import com.example.hypebeast.presentation.auth.AuthViewModel
import com.example.hypebeast.presentation.auth.AuthViewModelFactory
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private val firebaseAuth by lazy{ FirebaseAuth.getInstance()}
    private val viewModel by viewModels<AuthViewModel> { AuthViewModelFactory(AuthRepoImpl(
        AuthDataSource()
    )) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        isUserLoggedIn()
        doLogin()
        gotoSignUpPage()

    }

    private fun isUserLoggedIn(){
        firebaseAuth.currentUser?.let {
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }
    }

    private fun doLogin(){
        binding.btnSignIn.setOnClickListener {
            val email = binding.inputEmail.text.toString().trim()
            val password = binding.inputPasword.text.toString().trim()
            validateCredentials(email, password)
            signIn(email, password)
        }
    }

    private fun gotoSignUpPage(){
        binding.txtSignup.setOnClickListener{
        findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    private fun validateCredentials(email: String,password: String){
        if(email.isEmpty()){
            binding.inputEmail.error = "E-mail esta vacio"
            return
        }
        if(password.isEmpty()){
            binding.inputPasword.error = "Contraseña esta vacia"
            return
        }
    }

    private fun signIn(email:String, password:String){
        viewModel.signIn(email, password).observe(viewLifecycleOwner, Observer {result ->
            when(result) {
                is Result.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.btnSignIn.isEnabled = false
                }
                is Result.Sucess -> {
                    binding.progressBar.visibility = View.GONE
                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                    Toast.makeText(requireContext(), "Welcome ${result.data?.email}", Toast.LENGTH_SHORT).show()
                }
                is Result.Failure -> {
                    binding.btnSignIn.isEnabled = true
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), "Error: ${result.exception}", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}