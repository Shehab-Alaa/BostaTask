package com.bosta.task.data.remote

import android.app.Application
import com.bosta.task.util.JsonFileUtils
import com.bosta.task.util.NetworkConstants.BEST_SALE_FILE
import com.bosta.task.util.NetworkConstants.HOME_CATEGORIES_FILE
import com.bosta.task.util.NetworkConstants.TOP_ITEMS_FILE
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ApiRepository : ApiDataSource , KoinComponent{

    val app : Application by inject()

    override fun getHomeCategoriesResponse() = JsonFileUtils.getCategoryLocalJsonResponse(app, HOME_CATEGORIES_FILE)
    override fun getBestSalesResponse() = JsonFileUtils.getHomeLocalJsonResponse(app, BEST_SALE_FILE)
    override fun getTopPicksResponse() = JsonFileUtils.getHomeLocalJsonResponse(app, TOP_ITEMS_FILE)
}