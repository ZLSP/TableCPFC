package com.zlsp.tablecpfc.domain.product.usecases

import com.zlsp.tablecpfc.domain.product.ProductItem
import com.zlsp.tablecpfc.domain.product.ProductListRepository

class GetProductItemUseCase(val repository: ProductListRepository) {
    operator fun invoke(id: Int): ProductItem {
        return repository.getItem(id)
    }
}