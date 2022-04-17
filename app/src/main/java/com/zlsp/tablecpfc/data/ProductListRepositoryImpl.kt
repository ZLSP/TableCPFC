package com.zlsp.tablecpfc.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zlsp.tablecpfc.domain.CategoryTypes.*
import com.zlsp.tablecpfc.domain.CategoryTypes
import com.zlsp.tablecpfc.domain.product.ProductItem
import com.zlsp.tablecpfc.domain.product.ProductListRepository

object ProductListRepositoryImpl: ProductListRepository {

    private val productListLD = MutableLiveData<List<ProductItem>>()
    private val productList = sortedSetOf<ProductItem>({ o1, o2 -> o1.name.compareTo(o2.name) })
    private var autoIncrementId = 0

    override fun getList(): LiveData<List<ProductItem>> {
        return productListLD
    }

    override fun getListCategory(categoryTypes: CategoryTypes) {
        when(categoryTypes) {
            TODO()
        }
        updateList()
    }

    override fun getItem(id: Int): ProductItem {
        return productList.find {
            it.id == id
        } ?: throw RuntimeException("Element with id $id not found")
    }

    override fun calculateCPFC(productItem: ProductItem, weight: Int): ProductItem {
        TODO("Not yet implemented")
    }

    fun createList(ctx: Context) {
        for(product in ProductList(ctx)) {
            productList.add(product.copy(id = autoIncrementId++))
        }
    }

    fun updateList() {
        productListLD.value = productList.toList()
    }
}