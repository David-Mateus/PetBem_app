package com.example.petbem

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class HygieneItem(
    val id: Int,
    @DrawableRes val drawableId: Int,
    @StringRes val textStringId: Int,
    val color: Int
)
