package com.bosta.task.ui.fragment.main.home.best_sale

import com.bosta.task.R
import com.bosta.task.base.BaseAdapter
import com.bosta.task.base.BaseViewHolder
import com.bosta.task.data.model.HomeItem

class BestSalesAdapter(itemClick: (HomeItem) -> Unit) : BaseAdapter<HomeItem>(itemClick) {

    override fun layoutRes(): Int = R.layout.item_best_sales_view
    override fun onViewHolderCreated(viewHolder: BaseViewHolder<HomeItem>) {

    }
}