package com.zlsp.tablecpfc.domain.category

import androidx.lifecycle.LiveData

class CategoryListUseCases(private val repository: CategoryListRepository) {
    fun getList() : LiveData<List<CategoryItem>> {
        return repository.getList()
    }

    fun enableCategory(categoryItem: CategoryItem): Boolean {
        return repository.enableCategory(categoryItem)
    }
}