package com.bosta.task.data

import android.app.Application
import com.bosta.task.data.remote.ApiDataSource

interface DataSourceManager {

    fun getAppContext() : Application
    fun getApiRepository() : ApiDataSource
}