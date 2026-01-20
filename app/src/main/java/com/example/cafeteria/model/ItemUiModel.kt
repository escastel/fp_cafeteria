package com.example.cafeteria.model

import androidx.annotation.DrawableRes

/**
 * Data class que representa un elemento de un pedido.
 * Guarda toda la información necesaria para mostrar un producto
 * en la lista de pedidos.
 *
 * @property drawable ID del recurso drawable de la imagen del producto.
 * @property product Nombre del producto.
 * @property price Precio total del pedido para este producto.
 * @property amount Cantidad de unidades del producto pedidas.
 */
data class ItemUiModel(
    @DrawableRes val drawable: Int,
    val product: String,
    val price: Int,
    val amount: Int
)