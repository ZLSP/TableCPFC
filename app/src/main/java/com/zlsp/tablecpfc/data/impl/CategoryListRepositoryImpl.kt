package com.zlsp.tablecpfc.data.impl

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zlsp.tablecpfc.data.local.CategoryList
import com.zlsp.tablecpfc.domain.category.CategoryItem
import com.zlsp.tablecpfc.domain.category.CategoryListRepository

class CategoryListRepositoryImpl(
    application: Application
): CategoryListRepository {

    private val categoryListLD = MutableLiveData<List<CategoryItem>>()
    private val categoryList = CategoryList(application)

    init {
        categoryListLD.value = categoryList.toList()
    }

    override fun getList(): LiveData<List<CategoryItem>> {
        return categoryListLD
    }

    override fun enableCategory(categoryItem: CategoryItem): Boolean {
        return if (!categoryItem.state) {
            val oldList = categoryList.toList()
            categoryList.clear()
            for (item in oldList) {
                categoryList.add(item.copy(state = categoryItem.category == item.category))
            }
            categoryListLD.value = categoryList.toList()
            println(categoryList.toList())
            true
        } else
            false
    }

}