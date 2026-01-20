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

    /**
     * Actualiza el nombre del usuario
     */
    fun updateUsername(username: String){
        _uiState.update { it.copy(username = username) }
    }

    /**
     * Actualiza la cantidad de producto seleccionada
     */
    fun updateAmount(amount: Int){
        _uiState.update { it.copy(amount = amount) }
    }

    /**
     * Actualiza el producto seleccionado
     */
    fun updateOption(option: String){
        _uiState.update { it.copy(option = option) }
    }

    /**
     * Añade o actualiza un producto en la lista de pedidos
     */
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

    /**
     * Actualiza las varibles de diálogo.
     *
     * Si no se ha introducido el nombre de usuario, o productos al pedido,
     * o ambos, actualizará `showErrorDialog` y `errorText`.
     * Si ninguno de estos errores ha sucedido, actualizará `showDialog`.
     */
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

    /**
     *  Cierra el diálogo de confirmación si se pulsa el botón de "Aceptar".
     *
     *  Esta función limpia la pantalla, borrando el nombre de usuario y el pedido.
     */
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

    /**
     * Cierra el diálogo de confirmación si se pulsa fuera del diálogo.
     */
    fun dismissConfirmDialog() {
        _uiState.update { it.copy(showDialog = false) }
    }

    /**
     * Cierra el diálogo de error.
     */
    fun dismissErrorDialog() {
        _uiState.update { it.copy(showErrorDialog = false) }
    }
}