package com.ikhwankoto.sample_jetpackcompose.layout.view.lazyColumnObject

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
