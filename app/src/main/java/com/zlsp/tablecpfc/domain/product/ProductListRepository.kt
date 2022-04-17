package com.zlsp.tablecpfc.domain.product

import androidx.lifecycle.LiveData
import com.zlsp.tablecpfc.domain.CategoryTypes

interface ProductListRepository {

    fun getList() : LiveData<List<ProductItem>>

    fun getListCategory(categoryTypes: CategoryTypes)

    fun getItem(id: Int) : ProductItem

    fun calculateCPFC(productItem: ProductItem, weight: Int) : ProductItem
}