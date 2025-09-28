package com.btech.kotlinbasecamp.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.btech.kotlinbasecamp.R
import com.btech.kotlinbasecamp.base.BaseActivity
import com.btech.kotlinbasecamp.databinding.ActivitySecondBinding
import com.btech.kotlinbasecamp.ui.fragment.HomeFragment

class SecondActivity : BaseActivity<ActivitySecondBinding>(ActivitySecondBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, HomeFragment())
            .commit()

    }
}