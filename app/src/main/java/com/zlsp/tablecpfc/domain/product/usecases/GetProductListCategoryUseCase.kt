package com.zlsp.tablecpfc.domain.product.usecases

import com.zlsp.tablecpfc.domain.CategoryTypes
import com.zlsp.tablecpfc.domain.product.ProductListRepository

class GetProductListCategoryUseCase(val repository: ProductListRepository) {
    operator fun invoke(categoryTypes: CategoryTypes) {
        repository.getListCategory(categoryTypes)
    }
}