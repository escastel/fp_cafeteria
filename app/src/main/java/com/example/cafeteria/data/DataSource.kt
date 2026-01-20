package com.example.cafeteria.data

import com.example.cafeteria.R

/**
 * Objeto que contiene los datos de la aplicación.
 * Contiene un mapa que relaciona el nombre de cada producto con
 * su imagen `drawable` correspondiente.
 *
 * @property productImagesData
 *   - La clave (String) es el nombre del producto
 *   - El valor (Int) es el ID del drawable correspondiente
 */
object DataSource {
    val productImagesData = mapOf(
        "Jamón" to R.drawable.img_jamon,
        "Tortilla" to R.drawable.img_tortilla,
        "Bacon" to R.drawable.img_bacon
    )
}