package com.zlsp.tablecpfc.data.local

import android.content.Context
import com.zlsp.tablecpfc.R
import com.zlsp.tablecpfc.data.CategoryTypes
import com.zlsp.tablecpfc.domain.product.ProductItem

object ProductList {
    operator fun invoke(ctx: Context): HashSet<ProductItem>{
        return hashSetOf(
            ProductItem(ctx.resources.getString(R.string.app_name),0.0,0.0,0.0,0.0,0.0,CategoryTypes.MUSHROOM),
            ProductItem("auto",0.0,0.0,0.0,0.0,0.0, CategoryTypes.FRUIT)
        )
    }
}