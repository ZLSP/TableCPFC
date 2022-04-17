package com.zlsp.tablecpfc.present

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.zlsp.tablecpfc.data.ProductListRepositoryImpl
import com.zlsp.tablecpfc.domain.product.usecases.CalculateCPFCUseCase
import com.zlsp.tablecpfc.domain.product.usecases.GetProductItemUseCase

class MainViewModel(application: Application): AndroidViewModel(application) {
    private val repository = ProductListRepositoryImpl

    private val getProductItemUseCase = GetProductItemUseCase(repository)
    private val calculateCPFCUseCase = CalculateCPFCUseCase(repository)
}