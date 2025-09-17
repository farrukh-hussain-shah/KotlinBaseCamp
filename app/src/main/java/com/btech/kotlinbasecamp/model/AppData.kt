package com.btech.kotlinbasecamp.model

import androidx.annotation.DrawableRes

data class AppData(
    @DrawableRes val icon: Int,
    val name: String,
    var isChecked: Boolean = false
)
