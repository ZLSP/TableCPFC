package com.zlsp.tablecpfc.data

import android.content.Context
import com.zlsp.tablecpfc.R
import com.zlsp.tablecpfc.domain.CategoryTypes
import com.zlsp.tablecpfc.domain.product.ProductItem

object ProductList {
    operator fun invoke(ctx: Context): List<ProductItem>{
        return arrayListOf(
            ProductItem(ctx.resources.getString(R.string.app_name),0.0,0.0,0.0,0.0,0.0,CategoryTypes.FRUIT),
            ProductItem("auto",0.0,0.0,0.0,0.0,0.0,CategoryTypes.FRUIT)
        )
    }
}