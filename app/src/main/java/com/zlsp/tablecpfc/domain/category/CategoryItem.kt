package com.zlsp.tablecpfc.domain.category

import android.graphics.drawable.Drawable
import com.zlsp.tablecpfc.data.CategoryTypes

data class CategoryItem(
    val id: Int,
    val name: String,
    val img: Drawable,
    var category: CategoryTypes,
    var state: Boolean = DEFAULT_STATE
) {
    companion object {
        const val DEFAULT_STATE = false
    }
}