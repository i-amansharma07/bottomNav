package com.aman.bottomnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManagerNonConfig
import com.aman.bottomnav.databinding.ActivityMainBinding
import com.aman.bottomnav.fragments.Chat
import com.aman.bottomnav.fragments.Home
import com.aman.bottomnav.fragments.Profile

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val manager = supportFragmentManager

    private val home = Home()
    private val chat = Chat()
    private val profile = Profile()

    private var activeFrag :Fragment = home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = ActivityMainBinding.inflate(layoutInflater)
        binding = view
        setContentView(view.root)



    manager.beginTransaction().apply {
        add(R.id.frame,home,"Home")
        add(R.id.frame,chat,"chat").hide(chat)
        add(R.id.frame,profile,"profile").hide(profile)
    }.commit()


        binding.bottom.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    manager.beginTransaction().hide(activeFrag).show(home).commit()
                    activeFrag = home
                    true
                }
                R.id.chat -> {
                    manager.beginTransaction().hide(activeFrag).show(chat).commit()
                    activeFrag = chat
                    true
                }
                R.id.profile -> {
                    manager.beginTransaction().hide(activeFrag).show(profile).commit()
                    activeFrag = profile
                    true
                }
                else -> false
            }
        }

    }


}