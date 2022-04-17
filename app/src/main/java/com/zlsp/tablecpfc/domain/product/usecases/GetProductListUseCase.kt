package com.zlsp.tablecpfc.domain.product.usecases

import androidx.lifecycle.LiveData
import com.zlsp.tablecpfc.domain.product.ProductItem
import com.zlsp.tablecpfc.domain.product.ProductListRepository

class GetProductListUseCase(val repository: ProductListRepository) {
    operator fun invoke(): LiveData<List<ProductItem>> {
        return repository.getList()
    }
}