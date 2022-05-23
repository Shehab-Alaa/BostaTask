package com.bosta.task.di

import android.app.Application
import com.bosta.task.data.DataManager
import com.bosta.task.data.DataSourceManager
import com.bosta.task.data.remote.ApiDataSource
import com.bosta.task.data.remote.ApiRepository
import org.koin.dsl.module

val repositoriesModule = module {

    single { provideApiRepository() }
    single { provideDataManager(get(),get()) }
}

fun provideApiRepository() : ApiDataSource = ApiRepository()

fun provideDataManager(app: Application, apiRepository: ApiDataSource) : DataSourceManager = DataManager(app,apiRepository)
