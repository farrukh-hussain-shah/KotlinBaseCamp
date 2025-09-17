package com.btech.kotlinbasecamp.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.updatePadding
import androidx.viewbinding.ViewBinding
import com.btech.kotlinbasecamp.R

abstract class BaseActivityM<VB : ViewBinding>(
    private val bindingInflater: (layoutInflater: android.view.LayoutInflater) -> VB
) : AppCompatActivity() {

    private var _binding: VB? = null
    protected val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater.invoke(layoutInflater)
        setContentView(binding.root)

        // status bar setup
        setupStatusBar()

        setupViews()
        setupListeners()
    }

    private fun setupStatusBar() {
        // Allow drawing behind system bars
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // Set status bar color
        window.statusBarColor = getColor(R.color.background_color)

        // Light status bar (black icons)
        val insetsController = WindowInsetsControllerCompat(window, window.decorView)
        insetsController.isAppearanceLightStatusBars = true

        // Apply padding for status bar height
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val statusBarHeight = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top
            view.updatePadding(top = statusBarHeight)
            insets
        }
    }
    fun Int.toPx(context: Context): Int =
        (this * context.resources.displayMetrics.density).toInt()

    protected open fun setupViews() {}
    protected open fun setupListeners() {}

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
