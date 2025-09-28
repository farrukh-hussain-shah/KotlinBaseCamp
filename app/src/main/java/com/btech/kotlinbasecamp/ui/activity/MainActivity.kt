package com.btech.kotlinbasecamp.ui.activity

import android.os.Bundle
import com.btech.kotlinbasecamp.base.BaseActivity
import com.btech.kotlinbasecamp.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btnClick.setOnClickListener {
            start<SecondActivity>()
            toast ("Clicked")
        }
    }
}