package com.btech.kotlinbasecamp

import android.os.Bundle
import android.util.Log
import com.btech.kotlinbasecamp.adapters.FrequencyAdapter
import com.btech.kotlinbasecamp.base.BaseActivityM
import com.btech.kotlinbasecamp.bottomsheets.BottomAmount
import com.btech.kotlinbasecamp.bottomsheets.BottomAppSelect
import com.btech.kotlinbasecamp.bottomsheets.BottomCategorySelect
import com.btech.kotlinbasecamp.bottomsheets.BottomFrequencySelect
import com.btech.kotlinbasecamp.bottomsheets.BottomStartDateSelect
import com.btech.kotlinbasecamp.databinding.ActivityMainBinding
import com.btech.kotlinbasecamp.databinding.BottomStartDateBinding

class MainActivity : BaseActivityM<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appBottomSheet = BottomAppSelect()
        val priceBottomSheet = BottomAmount()
        val categoryBottomSheet = BottomCategorySelect()
        val frequencyBottomSheet = BottomFrequencySelect()
        val selectDateBottomSheet = BottomStartDateSelect()
        priceBottomSheet.onClick = {
            priceBottomSheet.dismiss()
            binding.tvAmountValue.text ="$ ${it.toString()}"
        }
        categoryBottomSheet.onClick = {
            categoryBottomSheet.dismiss()
            binding.tvCategoryValue.text = it.name
        }
        binding.tvCategoryValue.setOnClickListener {
            categoryBottomSheet.show(supportFragmentManager,"")
        }
        selectDateBottomSheet.onDateSelected = {
            selectDateBottomSheet.dismiss()
            binding.tvStartDateValue.text = it.toString()
            Log.d("MainActivity","MainActivity $it")
        }

        binding.tvStartDateValue.setOnClickListener {
            selectDateBottomSheet.show(supportFragmentManager,"")
        }
        frequencyBottomSheet.onClick = {
            frequencyBottomSheet.dismiss()
            binding.tvCategoryValue.text = it.name
        }
        binding.tvFrequencyValue.setOnClickListener {
            frequencyBottomSheet.show(supportFragmentManager,"")
        }
        appBottomSheet.onClick = {
            binding.tvTitle.text = it.name
            binding.icIcon.setImageResource(it.icon)
        }

        binding.tvAppValue.setOnClickListener {
            appBottomSheet.show(supportFragmentManager, "")
        }
        binding.tvAmountValue.setOnClickListener {
            priceBottomSheet.show(supportFragmentManager,"")
        }
    }

}
