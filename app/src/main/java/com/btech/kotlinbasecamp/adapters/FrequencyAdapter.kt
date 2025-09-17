package com.btech.kotlinbasecamp.adapters

import android.view.View
import androidx.core.view.isVisible
import com.btech.kotlinbasecamp.base.BaseAdapter
import com.btech.kotlinbasecamp.databinding.ItemAppSelectBinding
import com.btech.kotlinbasecamp.databinding.ItemFreequencySelectBinding
import com.btech.kotlinbasecamp.model.AppData

class FrequencyAdapter : BaseAdapter<AppData, ItemFreequencySelectBinding>(ItemFreequencySelectBinding::inflate) {
    override fun bind(binding: ItemFreequencySelectBinding, item: AppData, position: Int) {
        binding.tvName.text = item.name
        binding.ivEnd.isVisible = item.isChecked
    }
}
