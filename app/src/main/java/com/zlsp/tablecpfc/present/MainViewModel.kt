package com.zlsp.tablecpfc.present

import android.app.Application
import androidx.lifecycle.ViewModel
import com.zlsp.tablecpfc.domain.category.CategoryItem
import com.zlsp.tablecpfc.domain.category.CategoryListUseCases
import com.zlsp.tablecpfc.domain.product.ProductItem
import com.zlsp.tablecpfc.domain.product.ProductListUseCases

class MainViewModel(
    val application: Application,
    val categoryUseCases: CategoryListUseCases,
    val productListUseCases: ProductListUseCases
    ): ViewModel() {

    val productList = productListUseCases.getList()
    val categoryList = categoryUseCases.getList()

    fun setFilter(categoryItem: CategoryItem) {
        if (categoryUseCases.enableCategory(categoryItem))
            productListUseCases.setFilterList(categoryItem.category)
    }

    fun getProduct(id: Int): ProductItem {
        return productListUseCases.getItem(id)
    }
}