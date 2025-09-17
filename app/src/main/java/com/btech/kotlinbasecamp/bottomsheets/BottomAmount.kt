package com.btech.kotlinbasecamp.bottomsheets

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.btech.kotlinbasecamp.R
import com.btech.kotlinbasecamp.adapters.AppAdapter
import com.btech.kotlinbasecamp.base.BaseBottomSheetDialogFragment
import com.btech.kotlinbasecamp.databinding.BottomAppSelectBinding
import com.btech.kotlinbasecamp.model.AppData

class BottomAmount :
    BaseBottomSheetDialogFragment<BottomAppSelectBinding>(BottomAppSelectBinding::inflate) {
    var onClick: ((Double) -> Unit)? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.topBar.tvCenter.text = "Amount"
        binding.topBar.tvEnd.setOnClickListener {
            val text  = binding.etSearch.text
            if (text?.isNotEmpty() == true){
                onClick?.invoke(text.toString().toDouble())
            }
        }
    }
}
