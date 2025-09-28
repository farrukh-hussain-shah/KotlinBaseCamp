package com.btech.kotlinbasecamp.adapters

import android.util.Log
import android.widget.BaseAdapter
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.btech.kotlinbasecamp.databinding.ItemAppSelectBinding
import com.btech.kotlinbasecamp.model.AppData

class AppAdapter : BaseAdapter<AppData, ItemAppSelectBinding>(ItemAppSelectBinding::inflate) {
    var onClick: ((AppData) -> Unit)? = null

    private var selectedPosition = RecyclerView.NO_POSITION

    override fun bind(binding: ItemAppSelectBinding, item: AppData, position: Int) {
        binding.ivStart.setImageResource(item.icon)
        binding.tvName.text = item.name
        binding.ivEnd.isVisible = position == selectedPosition

        binding.main.setOnClickListener {
            if (selectedPosition != position) {
                val oldPos = selectedPosition
                selectedPosition = position

                if (oldPos != RecyclerView.NO_POSITION) notifyItemChanged(oldPos)
                notifyItemChanged(selectedPosition)

                onClick?.invoke(item)
            }
        }
    }
}
