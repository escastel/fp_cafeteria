package com.example.cafeteria.ui.screen

import androidx.lifecycle.ViewModel
import com.example.cafeteria.data.ItemRepository
import com.example.cafeteria.model.ItemUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * ViewModel de la pantalla principal de la aplicación.
 * Controla el estado de la pantalla.
 * @see AppUiState
 */
class AppViewModel(): ViewModel() {
    private val _uiState = MutableStateFlow(AppUiState())
    val uiState: StateFlow<AppUiState> = _uiState.asStateFlow()

    val productImages = ItemRepository().getProductImagesData()

    fun updateUsername(username: String){
        _uiState.update { it.copy(username = username) }
    }

    fun updateAmount(amount: Int){
        _uiState.update { it.copy(amount = amount) }
    }

    fun updateOption(option: String){
        _uiState.update { it.copy(option = option) }
    }

    fun updateOrder() {
        val currentState = _uiState.value

        if (currentState.amount <= 0) return

        val updatedList = currentState.orderList.toMutableList()
        val index = updatedList.indexOfFirst {
            it.product == currentState.option
        }

        if (index != -1) {
            val existing = updatedList[index]
            updatedList[index] = existing.copy(
                amount = existing.amount + currentState.amount,
                price = existing.price + (currentState.amount * 10)
            )
        } else {
            updatedList.add(
                ItemUiModel(
                    drawable = productImages.getValue(currentState.option),
                    product = currentState.option,
                    price = currentState.amount * 10,
                    amount = currentState.amount
                )
            )
        }

        _uiState.update {
            it.copy(
                orderList = updatedList,
                amount = 0
            )
        }
    }

    fun updateDialog() {
        val currentState = _uiState.value

        if (currentState.orderList.isEmpty() && currentState.username.isBlank()){
            _uiState.update {
                it.copy(showErrorDialog = true, errorText = 1)
            }
        }
        else if (currentState.username.isBlank()){
            _uiState.update {
                it.copy(showErrorDialog = true, errorText = 2)
            }
        }
        else if (currentState.orderList.isEmpty()){
            _uiState.update {
                it.copy(showErrorDialog = true, errorText = 3)
            }
        }
        else
            _uiState.update { it.copy(showDialog = true) }
    }

    fun confirmConfirmDialog() {
        _uiState.update {
            it.copy(
                orderList = emptyList(),
                username = "",
                showDialog = false,
                showErrorDialog = false
            )
        }
    }

    fun dismissConfirmDialog() {
        _uiState.update { it.copy(showDialog = false) }
    }

    fun dismissErrorDialog() {
        _uiState.update { it.copy(showErrorDialog = false) }
    }
}