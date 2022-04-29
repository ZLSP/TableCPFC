package com.zlsp.tablecpfc.domain.product

import androidx.lifecycle.LiveData
import com.zlsp.tablecpfc.data.CategoryTypes

class ProductListUseCases(private val repository: ProductListRepository) {
    fun getList() : LiveData<List<ProductItem>> {
        return repository.getList()
    }

    fun getItem(id: Int) : ProductItem {
        return repository.getItem(id)
    }

    fun calculateCPFC(productItem: ProductItem, weight: Int) : ProductItem {
        return repository.calculateCPFC(productItem, weight)
    }
    fun addFavorite(productItem: ProductItem) {
        repository.addFavorite(productItem)
    }
    fun setFilterList(categoryTypes: CategoryTypes) {
        repository.setFilterList(categoryTypes)
    }
}