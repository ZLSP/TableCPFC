package com.zlsp.tablecpfc.present.di

import com.zlsp.tablecpfc.data.impl.CategoryListRepositoryImpl
import com.zlsp.tablecpfc.data.impl.ProductListRepositoryImpl
import com.zlsp.tablecpfc.domain.category.CategoryListUseCases
import com.zlsp.tablecpfc.domain.product.ProductListUseCases
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun provideCategoryListUseCases(repositoryImpl: CategoryListRepositoryImpl) : CategoryListUseCases {
        return CategoryListUseCases(repositoryImpl)
    }
    @Provides
    fun provideProductListUseCases(repositoryImpl: ProductListRepositoryImpl) : ProductListUseCases {
        return ProductListUseCases(repositoryImpl)
    }
}