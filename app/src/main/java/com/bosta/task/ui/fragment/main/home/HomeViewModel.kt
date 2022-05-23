package com.bosta.task.ui.fragment.main.home

import com.bosta.task.base.BaseViewModel
import com.bosta.task.data.DataSourceManager
import com.bosta.task.data.model.HomeCategoryItem
import com.bosta.task.data.model.HomeItem
import com.bosta.task.ui.fragment.main.home.best_sale.BestSalesAdapter
import com.bosta.task.ui.fragment.main.home.category.HomeCategoriesAdapter
import com.bosta.task.ui.fragment.main.home.top_pick.TopPicksAdapter

class HomeViewModel(dataManager: DataSourceManager) : BaseViewModel(dataManager)  {

    val homeCategoriesAdapter = HomeCategoriesAdapter(::onCategoryItemClick)
    val bestSalesAdapter = BestSalesAdapter(::onBestSaleItemClick)
    val topPicksAdapter = TopPicksAdapter(::onTopPickItemClick)

    init{
        getHomeCategories()
        getBestSalesItems()
        getTopPicksItems()
    }

    private fun getHomeCategories(){

    }

    private fun getBestSalesItems(){

    }

    private fun getTopPicksItems(){

    }

    private fun onCategoryItemClick(item: HomeCategoryItem) {
        setValue(item)
    }

    private fun onBestSaleItemClick(item: HomeItem) {
        setValue(item)
    }

    private fun onTopPickItemClick(item: HomeItem) {
        setValue(item)
    }
}