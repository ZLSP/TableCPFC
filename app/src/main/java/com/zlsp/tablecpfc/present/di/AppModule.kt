package com.zlsp.tablecpfc.present.di

import android.app.Application
import com.zlsp.tablecpfc.domain.category.CategoryListUseCases
import com.zlsp.tablecpfc.domain.product.ProductListUseCases
import com.zlsp.tablecpfc.present.App
import com.zlsp.tablecpfc.present.MainViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val application: App) {

    @Provides
    fun provideApplication() : Application {
        return application
    }
    @Provides
    fun provideMainViewModelFactory(
        categoryUseCases: CategoryListUseCases,
        productListUseCases: ProductListUseCases
    ) : MainViewModelFactory {
        return MainViewModelFactory(
            application,categoryUseCases,productListUseCases
        )
    }


}