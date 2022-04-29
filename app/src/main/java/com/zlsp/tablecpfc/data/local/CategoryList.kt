package com.zlsp.tablecpfc.data.local

import android.annotation.SuppressLint
import android.content.Context
import com.zlsp.tablecpfc.R
import com.zlsp.tablecpfc.data.CategoryTypes
import com.zlsp.tablecpfc.domain.category.CategoryItem
import kotlin.collections.LinkedHashSet

object CategoryList {
    @SuppressLint("UseCompatLoadingForDrawables")
    operator fun invoke(ctx: Context): LinkedHashSet<CategoryItem> {
        val categoryList = LinkedHashSet<CategoryItem>()
        categoryList.apply {
            add(CategoryItem(
                1,
                ctx.resources.getString(R.string.c_favorite),
                ctx.getDrawable(R.drawable.cat_favorite)!!,
                CategoryTypes.FAVORITES)
            )
            add(CategoryItem(
                2,
                ctx.resources.getString(R.string.c_all),
                ctx.getDrawable(R.drawable.cat_all)!!,
                CategoryTypes.ALL,
                true)
            )
            add(CategoryItem(
                3,
                ctx.resources.getString(R.string.c_veggie),
                ctx.getDrawable(R.drawable.cat_veggie)!!,
                CategoryTypes.VEGGIE)
            )
            add(CategoryItem(
                4,
                ctx.resources.getString(R.string.c_fruit),
                ctx.getDrawable(R.drawable.cat_fruit)!!,
                CategoryTypes.FRUIT)
            )
            add(CategoryItem(
                5,
                ctx.resources.getString(R.string.c_groat),
                ctx.getDrawable(R.drawable.cat_groats)!!,
                CategoryTypes.GROAT)
            )
            add(CategoryItem(
                6,
                ctx.resources.getString(R.string.c_meat),
                ctx.getDrawable(R.drawable.cat_meat)!!,
                CategoryTypes.MEAT)
            )
            add(CategoryItem(
                7,
                ctx.resources.getString(R.string.c_fish),
                ctx.getDrawable(R.drawable.cat_fish)!!,
                CategoryTypes.FISH)
            )
            add(CategoryItem(
                8,
                ctx.resources.getString(R.string.c_milk),
                ctx.getDrawable(R.drawable.cat_milk)!!,
                CategoryTypes.MILK)
            )
            add(CategoryItem(
                9,
                ctx.resources.getString(R.string.c_mushroom),
                ctx.getDrawable(R.drawable.cat_mushroom)!!,
                CategoryTypes.MUSHROOM)
            )
            add(CategoryItem(
                10,
                ctx.resources.getString(R.string.c_nut),
                ctx.getDrawable(R.drawable.cat_nut)!!,
                CategoryTypes.NUT)
            )
            add(CategoryItem(
                11,
                ctx.resources.getString(R.string.c_other),
                ctx.getDrawable(R.drawable.cat_other)!!,
                CategoryTypes.OTHER)
            )
        }
        return categoryList
    }
}