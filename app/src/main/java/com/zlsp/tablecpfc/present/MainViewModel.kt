package com.zlsp.tablecpfc.present

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.zlsp.tablecpfc.data.Component
import com.zlsp.tablecpfc.domain.category.CategoryItem
import com.zlsp.tablecpfc.domain.category.CategoryListUseCases
import com.zlsp.tablecpfc.domain.product.ProductItem
import com.zlsp.tablecpfc.domain.product.ProductListUseCases

class MainViewModel(application: Application): AndroidViewModel(application) {

    lateinit var categoryUseCases: CategoryListUseCases
    lateinit var productListUseCases: ProductListUseCases
    lateinit var categoryList: LiveData<List<CategoryItem>>
    lateinit var productList: LiveData<List<ProductItem>>

    init {
        Component().injectMainViewModel(this, application)
    }

    fun setFilter(categoryItem: CategoryItem) {
        if (categoryUseCases.enableCategory(categoryItem))
            productListUseCases.setFilterList(categoryItem.category)
    }

    fun getProduct(id: Int): ProductItem {
        return productListUseCases.getItem(id)
    }
}