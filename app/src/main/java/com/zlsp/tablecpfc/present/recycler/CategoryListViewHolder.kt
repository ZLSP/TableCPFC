package com.zlsp.tablecpfc.present.recycler

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.zlsp.tablecpfc.R

class CategoryListViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val tvName: TextView = view.findViewById(R.id.tv_c_name)
    val cvBlock: ConstraintLayout = view.findViewById(R.id.cl_c_block)
}