package com.btech.kotlinbasecamp.bottomsheets

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.btech.kotlinbasecamp.R
import com.btech.kotlinbasecamp.adapters.AppAdapter
import com.btech.kotlinbasecamp.base.BaseBottomSheetDialogFragment
import com.btech.kotlinbasecamp.databinding.BottomAppSelectBinding
import com.btech.kotlinbasecamp.model.AppData

class BottomAppSelect :
    BaseBottomSheetDialogFragment<BottomAppSelectBinding>(BottomAppSelectBinding::inflate) {

    var onClick: ((AppData) -> Unit)? = null
    private var appData: AppData? = null
    private val adapter by lazy { AppAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listOfData = listOf(
            AppData(R.drawable.amazon, "Amazon"),
            AppData(R.drawable.apple, "Apple"),
            AppData(R.drawable.newyorktimes, "New York Times"),
            AppData(R.drawable.spotify, "Spotify"),
            AppData(R.drawable.wsj, "Wall Street Journal"),
        )

        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = adapter
        adapter.setItems(listOfData)

        adapter.onClick = { app ->
            appData = app
        }

        binding.topBar.tvEnd.setOnClickListener {
            appData?.let {
                onClick?.invoke(it)
                dismiss()
            }
        }
    }
}
