package com.btech.kotlinbasecamp.base

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewbinding.ViewBinding
import com.btech.kotlinbasecamp.R

abstract class BaseActivity<VB : ViewBinding>(
    private val bindingInflater: (layoutInflater: android.view.LayoutInflater) -> VB
) : AppCompatActivity() {

    private var _binding: VB? = null
    protected val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater.invoke(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    /** Toast helper */
    fun toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, duration).show()
    }

    /** Navigation helper without extras */
    inline fun <reified T : AppCompatActivity> start() {
        val intent = Intent(this, T::class.java)
        startActivity(intent)
    }

    /** Navigation helper with extras */
    inline fun <reified T : AppCompatActivity> start(
        block: Intent.() -> Unit
    ) {
        val intent = Intent(this, T::class.java).apply(block)
        startActivity(intent)
    }
}
