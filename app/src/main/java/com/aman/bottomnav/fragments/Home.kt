package com.aman.bottomnav.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aman.bottomnav.R
import com.aman.bottomnav.SecondActivity
import com.aman.bottomnav.databinding.FragmentHomeBinding


class Home : Fragment() {
    private lateinit var binding:FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         val view = FragmentHomeBinding.inflate(inflater,container,false)
        binding  =view
        return view.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.sass.setOnClickListener {
            startActivity(Intent(requireContext(),SecondActivity::class.java))
        }
    }
}