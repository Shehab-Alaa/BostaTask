package com.bosta.task.data.remote

import com.bosta.task.data.remote.network.ApiService
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ApiRepository : ApiDataSource, KoinComponent {

    private val apiService : ApiService by inject()
}