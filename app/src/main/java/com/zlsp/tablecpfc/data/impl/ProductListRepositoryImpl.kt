package com.zlsp.tablecpfc.data.impl

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zlsp.tablecpfc.data.local.ProductList
import com.zlsp.tablecpfc.data.CategoryTypes
import com.zlsp.tablecpfc.domain.product.ProductItem
import com.zlsp.tablecpfc.domain.product.ProductListRepository
import java.lang.RuntimeException

class ProductListRepositoryImpl(
    private val application: Application
): ProductListRepository {

    private val productListLD = MutableLiveData<List<ProductItem>>()
    private val productList = ProductList(application)

    init {
        productListLD.value = productList.toList()
    }

    override fun getList(): LiveData<List<ProductItem>> {
        return productListLD
    }

    override fun getItem(id: Int): ProductItem {
        return productList.find {
            it.id == id
        } ?: throw RuntimeException("Error id: $id")
    }

    override fun calculateCPFC(productItem: ProductItem, weight: Int): ProductItem {
        return productItem.copy(
            calorie = calculateWeight(productItem.calorie, weight),
            fat = calculateWeight(productItem.fat, weight),
            carbs = calculateWeight(productItem.carbs, weight),
            protein = calculateWeight(productItem.protein, weight),
        )
    }

    override fun setFilterList(categoryTypes: CategoryTypes) {
        productList.clear()
        productList.addAll(filterList(categoryTypes))
        updateList()
    }

    override fun addFavorite(productItem: ProductItem) {
        TODO("Not yet implemented")
    }

    override fun deleteFavorite(productItem: ProductItem) {
        TODO("Not yet implemented")
    }

    private fun calculateWeight(table: Double, weight: Int): Double {
        return (table/ProductItem.DEFAULT_WEIGHT*weight)
    }

    private fun updateList() {
        productListLD.value = productList.toList()
    }

    private fun filterList(categoryTypes: CategoryTypes): HashSet<ProductItem> {
        val newList = HashSet<ProductItem>()
        if (categoryTypes == CategoryTypes.ALL) {
            return ProductList(application)
        }
        for (item in ProductList(application)) {
            if (item.category == categoryTypes) {
                newList.add(item)
            }
        }
        return newList
    }
}