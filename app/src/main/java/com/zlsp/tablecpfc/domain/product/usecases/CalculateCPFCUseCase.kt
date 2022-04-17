package com.zlsp.tablecpfc.domain.product.usecases

import com.zlsp.tablecpfc.domain.product.ProductItem
import com.zlsp.tablecpfc.domain.product.ProductListRepository

class CalculateCPFCUseCase(val repository: ProductListRepository) {
    operator fun invoke(productItem: ProductItem, weight: Int): ProductItem {
        return repository.calculateCPFC(productItem, weight)
    }
}