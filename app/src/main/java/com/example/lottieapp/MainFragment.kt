package com.example.lottieapp

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lottieapp.databinding.FragmentMainBinding

class MainFragment: Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider.AndroidViewModelFactory(requireActivity().application).create(MainViewModel::class.java).apply {
            liveList?.observe(requireActivity(), Observer {
                myAdapter.submitList(it)
                myAdapter.notifyDataSetChanged()
            })
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mainBinding = FragmentMainBinding.inflate(inflater, container, false)
        mainBinding.vm = viewModel
        return mainBinding.root
    }
}