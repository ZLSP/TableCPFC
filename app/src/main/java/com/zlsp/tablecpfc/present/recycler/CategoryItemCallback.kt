package com.zlsp.tablecpfc.present.recycler

import androidx.recyclerview.widget.DiffUtil
import com.zlsp.tablecpfc.domain.category.CategoryItem

class CategoryItemCallback: DiffUtil.ItemCallback<CategoryItem>() {
    override fun areItemsTheSame(oldItem: CategoryItem, newItem: CategoryItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CategoryItem, newItem: CategoryItem): Boolean {
        return oldItem == newItem
    }
}