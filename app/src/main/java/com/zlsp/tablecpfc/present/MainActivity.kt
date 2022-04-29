package com.zlsp.tablecpfc.present

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zlsp.tablecpfc.data.Component
import com.zlsp.tablecpfc.databinding.ActivityMainBinding
import com.zlsp.tablecpfc.present.recycler.CategoryListAdapter
import com.zlsp.tablecpfc.present.recycler.ProductListAdapter

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    lateinit var categoryAdapter: CategoryListAdapter
    lateinit var productAdapter: ProductListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Component().injectActivity(this)
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