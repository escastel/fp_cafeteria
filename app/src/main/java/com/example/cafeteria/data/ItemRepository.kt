package com.example.cafeteria.data

class ItemRepository {
    fun getProductImagesData(): Map<String, Int> {
        return DataSource.productImagesData
    }
}