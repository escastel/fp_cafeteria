package com.example.cafeteria.model

import androidx.annotation.DrawableRes

data class ItemUiModel(
    @DrawableRes val drawable: Int,
    val product: String,
    val price: Int,
    val amount: Int
)