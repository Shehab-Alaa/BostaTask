package com.bosta.task.ui.fragment.main.home.category

import com.bosta.task.R
import com.bosta.task.base.BaseAdapter
import com.bosta.task.base.BaseViewHolder
import com.bosta.task.data.model.HomeCategoryItem

class HomeCategoriesAdapter(itemClick: (HomeCategoryItem) -> Unit) : BaseAdapter<HomeCategoryItem>(itemClick) {

    override fun layoutRes(): Int = R.layout.item_home_category_view
    override fun onViewHolderCreated(viewHolder: BaseViewHolder<HomeCategoryItem>) {

    }
}