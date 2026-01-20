package com.example.cafeteria.ui.screen

import com.example.cafeteria.model.ItemUiModel

/**
 * Data class que contiene el estado de la pantalla principal.
 * @see AppViewModel
 */
data class AppUiState(
    val username: String = "",
    val option: String = "Jamón",
    val amount: Int = 0,
    val orderList: List<ItemUiModel> = emptyList(),
    val showDialog: Boolean = false,
    val showErrorDialog: Boolean = false,
    val errorText: Int = 0
)