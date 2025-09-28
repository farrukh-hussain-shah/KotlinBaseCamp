package com.btech.kotlinbasecamp.adapters

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.btech.kotlinbasecamp.databinding.ItemFreequencySelectBinding
import com.btech.kotlinbasecamp.model.AppData

class FrequencyAdapter : BaseAdapter<AppData, ItemFreequencySelectBinding>(ItemFreequencySelectBinding::inflate) {
    private var selectedPosition = RecyclerView.NO_POSITION
    var onClick: ((AppData) -> Unit)? = null


    override fun bind(binding: ItemFreequencySelectBinding, item: AppData, position: Int) {
        binding.tvName.text = item.name
        binding.ivEnd.isVisible = position == selectedPosition

        binding.root.setOnClickListener {
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
