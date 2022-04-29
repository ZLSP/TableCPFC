package com.zlsp.tablecpfc.present.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.zlsp.tablecpfc.R
import com.zlsp.tablecpfc.domain.category.CategoryItem
import java.lang.RuntimeException

class CategoryListAdapter: ListAdapter<CategoryItem, CategoryListViewHolder>(CategoryItemCallback()) {

    var onItemClickListener: ((CategoryItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryListViewHolder {
        val layout = when(viewType){
            VIEW_TYPE_DEF -> R.layout.category_item_def
            VIEW_TYPE_CHECK -> R.layout.category_item_check
            else -> throw RuntimeException("Error viewType $viewType")
        }


        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return CategoryListViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryListViewHolder, position: Int) {
        holder.tvName.text = getItem(position).name
        holder.cvBlock.background = getItem(position).img
        holder.view.setOnClickListener {
            onItemClickListener?.invoke(getItem(position))
        }
    }


    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).state) VIEW_TYPE_CHECK else VIEW_TYPE_DEF
    }

    companion object {
        const val VIEW_TYPE_DEF = 1
        const val VIEW_TYPE_CHECK = 2
    }
}