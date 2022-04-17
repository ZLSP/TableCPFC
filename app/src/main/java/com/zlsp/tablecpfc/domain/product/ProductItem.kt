package com.zlsp.tablecpfc.domain.product

import com.zlsp.tablecpfc.domain.CategoryTypes

data class ProductItem(
    val name: String,
    val calorie: Double,
    val protein: Double,
    val fat: Double,
    val carbs: Double,
    val gi: Double,
    val category: CategoryTypes,
    val id: Int = UNDEFINED_ID,
    val weight: Int = DEFAULT_WEIGHT,
    val favorite: Boolean = DEFAULT_FAVORITE
) {
    companion object {
        const val UNDEFINED_ID = -1
        const val DEFAULT_FAVORITE = false
        const val DEFAULT_WEIGHT = 100
    }

    override fun equals(other: Any?): Boolean {
        return other is ProductItem && (id == other.id && category == other.category)
    }
}
