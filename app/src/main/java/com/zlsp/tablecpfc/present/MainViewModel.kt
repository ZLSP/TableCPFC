package com.zlsp.tablecpfc.present

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.zlsp.tablecpfc.data.impl.CategoryListRepositoryImpl
import com.zlsp.tablecpfc.data.impl.ProductListRepositoryImpl
import com.zlsp.tablecpfc.domain.category.CategoryItem
import com.zlsp.tablecpfc.domain.category.CategoryListUseCases
import com.zlsp.tablecpfc.domain.product.ProductItem
import com.zlsp.tablecpfc.domain.product.ProductListUseCases

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val categoryUseCases = CategoryListUseCases(CategoryListRepositoryImpl(application))
    private val productListUseCases = ProductListUseCases(ProductListRepositoryImpl(application))

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