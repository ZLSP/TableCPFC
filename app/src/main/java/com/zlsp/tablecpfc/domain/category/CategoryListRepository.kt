package com.zlsp.tablecpfc.domain.category

import androidx.lifecycle.LiveData

interface CategoryListRepository {
    fun getList() : LiveData<List<CategoryItem>>

    fun enableCategory(categoryItem: CategoryItem) : Boolean
}