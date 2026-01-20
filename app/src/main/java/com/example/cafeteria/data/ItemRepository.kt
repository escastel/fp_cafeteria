package com.example.cafeteria.data

/**
 * Repositorio que gestiona el acceso a los datos de la aplicaación.
 * @see DataSource
 */
class ItemRepository {
    /**
     * Obtiene el mapa `productImagesData` desde el DataSource.
     *
     * @return Map<String, Int> que relaciona nombres de productos con los IDs de su imagen relacionada
     */
    fun getProductImagesData(): Map<String, Int> {
        return DataSource.productImagesData
    }
}