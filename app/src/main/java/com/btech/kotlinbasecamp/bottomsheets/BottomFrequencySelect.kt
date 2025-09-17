package com.btech.kotlinbasecamp.bottomsheets

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.btech.kotlinbasecamp.R
import com.btech.kotlinbasecamp.adapters.AppAdapter
import com.btech.kotlinbasecamp.adapters.FrequencyAdapter
import com.btech.kotlinbasecamp.base.BaseBottomSheetDialogFragment
import com.btech.kotlinbasecamp.databinding.BottomAppSelectBinding
import com.btech.kotlinbasecamp.model.AppData

class BottomFrequencySelect :
    BaseBottomSheetDialogFragment<BottomAppSelectBinding>(BottomAppSelectBinding::inflate) {
    var onClick: ((AppData) -> Unit)? = null
    private val adapter by lazy { FrequencyAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // sample list
        val listOfData = listOf(
            AppData(R.drawable.subsrciption, "Weekly"),
            AppData(R.drawable.utility, "Monthly"),
            AppData(R.drawable.ic_money_2, "Anually"),
        )
        binding.etSearch.visibility = View.GONE
        binding.recyclerView.adapter = adapter
        adapter.setItems(listOfData)
        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        // item click
        adapter.setOnItemClickListener { app, position ->
            onClick?.invoke(app)
            dismiss() // close sheet when selected
        }
    }
}
