package com.btech.kotlinbasecamp

import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import com.btech.kotlinbasecamp.base.BaseActivity
import com.btech.kotlinbasecamp.bottomsheets.BottomStartDateSelect
import com.btech.kotlinbasecamp.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize bottom sheets
        val appBottomSheet = BottomAppSelect()
        val priceBottomSheet = BottomAmount()
        val categoryBottomSheet = BottomCategorySelect()
        val frequencyBottomSheet = BottomFrequencySelect()
        val selectDateBottomSheet = BottomStartDateSelect()

        // Handle callbacks
        priceBottomSheet.onClick = {
            binding.tvAmountValue.text = "$ $it"
            priceBottomSheet.dismiss()
        }

        categoryBottomSheet.onClick = { appData ->
            binding.tvCategoryValue.apply {
                text = appData.name

                val startDrawable = ContextCompat.getDrawable(context, appData.icon)?.apply {
                    setBounds(0, 0, 24.toPx(context), 24.toPx(context)) // 24dp size
                }

                val endDrawable = ContextCompat.getDrawable(context, R.drawable.unfold_more)?.apply {
                    setBounds(0, 0, 20.toPx(context), 20.toPx(context)) // 20dp size
                }

                setCompoundDrawables(startDrawable, null, endDrawable, null)
                compoundDrawablePadding = 8.toPx(context) // space between text and icons
            }
            categoryBottomSheet.dismiss()
        }


        frequencyBottomSheet.onClick = {
            binding.tvFrequencyValue.text = it.name
            frequencyBottomSheet.dismiss()
        }

        selectDateBottomSheet.onDateSelected = { date ->
            binding.tvStartDateValue.text = date.toString()
            Log.d("MainActivity", "Selected Date: $date")
            selectDateBottomSheet.dismiss()
        }

        appBottomSheet.onClick = {
            binding.tvTitle.text = it.name
            binding.tvAppValue.text = it.name
            binding.icIcon.setImageResource(it.icon)
        }

        // Open bottom sheets on click
        binding.tvAppValue.setOnClickListener {
            appBottomSheet.show(supportFragmentManager, "AppSelect")
        }

        binding.tvAmountValue.setOnClickListener {
            priceBottomSheet.show(supportFragmentManager, "AmountSelect")
        }

        binding.tvCategoryValue.setOnClickListener {
            categoryBottomSheet.show(supportFragmentManager, "CategorySelect")
        }

        binding.tvFrequencyValue.setOnClickListener {
            frequencyBottomSheet.show(supportFragmentManager, "FrequencySelect")
        }

        binding.tvStartDateValue.setOnClickListener {
            selectDateBottomSheet.show(supportFragmentManager, "DateSelect")
        }
    }
}
