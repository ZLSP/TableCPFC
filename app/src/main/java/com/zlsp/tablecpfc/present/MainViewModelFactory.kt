package com.zlsp.tablecpfc.present

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zlsp.tablecpfc.domain.category.CategoryListUseCases
import com.zlsp.tablecpfc.domain.product.ProductListUseCases
import java.lang.RuntimeException
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    private val application: Application,
    private val categoryUseCases: CategoryListUseCases,
    private val productListUseCases: ProductListUseCases
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(application, categoryUseCases, productListUseCases) as T
        }
            throw RuntimeException("Error view model $modelClass")
    }
}