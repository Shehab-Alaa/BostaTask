package com.bosta.task.ui.fragment.main.home.top_pick

import com.bosta.task.R
import com.bosta.task.base.BaseAdapter
import com.bosta.task.base.BaseViewHolder
import com.bosta.task.data.model.HomeItem

class TopPicksAdapter(itemClick: (HomeItem) -> Unit) : BaseAdapter<HomeItem>(itemClick) {

    override fun layoutRes(): Int = R.layout.item_top_picks_view
    override fun onViewHolderCreated(viewHolder: BaseViewHolder<HomeItem>) {

    }
}