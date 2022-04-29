package com.zlsp.tablecpfc.data

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.zlsp.tablecpfc.data.impl.CategoryListRepositoryImpl
import com.zlsp.tablecpfc.data.impl.ProductListRepositoryImpl
import com.zlsp.tablecpfc.databinding.ActivityMainBinding
import com.zlsp.tablecpfc.domain.category.CategoryListUseCases
import com.zlsp.tablecpfc.domain.product.ProductListUseCases
import com.zlsp.tablecpfc.present.MainActivity
import com.zlsp.tablecpfc.present.MainViewModel
import com.zlsp.tablecpfc.present.recycler.CategoryListAdapter
import com.zlsp.tablecpfc.present.recycler.ProductListAdapter

class Component {
    fun injectActivity(activity: MainActivity) {
        activity.apply {
            categoryAdapter = CategoryListAdapter()
            productAdapter = ProductListAdapter()
            viewModel = ViewModelProvider(this)[MainViewModel::class.java]
            binding = ActivityMainBinding.inflate(layoutInflater)
        }
    }
    fun injectMainViewModel(viewModel: MainViewModel, application: Application) {
        viewModel.apply {
            categoryUseCases = CategoryListUseCases(CategoryListRepositoryImpl(application))
            productListUseCases = ProductListUseCases(ProductListRepositoryImpl(application))
            categoryList = categoryUseCases.getList()
            productList = productListUseCases.getList()
        }
    }
}