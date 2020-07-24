package com.example.lottieapp

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.lottieapp.databinding.ActivityLoginBinding

class LoginFragment: Fragment() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider.AndroidViewModelFactory(requireActivity().application).create(LoginViewModel::class.java).apply {
            loginOk.observe(this@LoginFragment, Observer {
                if (it) {
                    Navigation.findNavController(requireActivity(), R.id.nav_host_main).navigateUp()
                }
            })
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = ActivityLoginBinding.inflate(inflater, container, false)
        binding.vm = viewModel
        return binding.root
    }

}