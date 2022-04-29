package com.zlsp.tablecpfc.present.di

import android.app.Application
import com.zlsp.tablecpfc.data.impl.CategoryListRepositoryImpl
import com.zlsp.tablecpfc.data.impl.ProductListRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class DataModule {
    @Provides
    fun provideCategoryListRepository(application: Application) : CategoryListRepositoryImpl {
        return CategoryListRepositoryImpl(application)
    }
    @Provides
    fun provideProductListRepository(application: Application) : ProductListRepositoryImpl {
        return ProductListRepositoryImpl(application)
    }

}