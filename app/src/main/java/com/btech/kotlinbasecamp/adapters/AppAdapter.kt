package com.btech.kotlinbasecamp.adapters

import androidx.core.view.isVisible
import com.btech.kotlinbasecamp.base.BaseAdapter
import com.btech.kotlinbasecamp.databinding.ItemAppSelectBinding
import com.btech.kotlinbasecamp.model.AppData

class AppAdapter : BaseAdapter<AppData, ItemAppSelectBinding>(ItemAppSelectBinding::inflate) {
    override fun bind(binding: ItemAppSelectBinding, item: AppData, position: Int) {
        binding.ivStart.setImageResource(item.icon)
        binding.tvName.text = item.name
        binding.ivEnd.isVisible = item.isChecked
    }
}
