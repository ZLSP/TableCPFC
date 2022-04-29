package com.zlsp.tablecpfc.present

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.zlsp.tablecpfc.databinding.ActivityMainBinding
import com.zlsp.tablecpfc.present.recycler.CategoryListAdapter
import com.zlsp.tablecpfc.present.recycler.ProductListAdapter
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }
    private val categoryAdapter: CategoryListAdapter by lazy {
        CategoryListAdapter()
    }
    private val productAdapter: ProductListAdapter by lazy {
        ProductListAdapter()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initRecyclerViews()
        viewModel.productList.observe(this) {

        }
        viewModel.categoryList.observe(this) {
            categoryAdapter.submitList(it)
        }
    }

    private fun initRecyclerViews() {
        binding.apply {
            rvCategories.adapter = categoryAdapter
//            rvProducts.adapter = productAdapter
        }
        setupCategoryOnClickListener()
    }
    private fun setupCategoryOnClickListener() {
        categoryAdapter.onItemClickListener = {
            viewModel.setFilter(it)
        }
    }
}