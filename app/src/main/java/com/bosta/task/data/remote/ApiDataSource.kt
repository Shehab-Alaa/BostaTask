package com.bosta.task.data.remote

import com.bosta.task.data.model.HomeCategoryItem
import com.bosta.task.data.model.HomeItem

interface ApiDataSource{
    fun getHomeCategoriesResponse() : List<HomeCategoryItem>
    fun getBestSalesResponse() : List<HomeItem>
    fun getTopPicksResponse() : List<HomeItem>
}