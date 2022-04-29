package com.zlsp.tablecpfc.domain.product

import androidx.lifecycle.LiveData
import com.zlsp.tablecpfc.data.CategoryTypes

interface ProductListRepository {

    fun getList() : LiveData<List<ProductItem>>

    fun getItem(id: Int) : ProductItem

    fun calculateCPFC(productItem: ProductItem, weight: Int) : ProductItem

    fun setFilterList(categoryTypes: CategoryTypes)

    fun addFavorite(productItem: ProductItem)

    fun deleteFavorite(productItem: ProductItem)
}