package com.bosta.task.data

import android.app.Application
import com.bosta.task.data.remote.ApiDataSource

class DataManager(private val app: Application, private val apiRepository: ApiDataSource) : DataSourceManager {

    override fun getAppContext() = app
    override fun getApiRepository() = apiRepository
}