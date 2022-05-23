package com.bosta.task.app

import android.app.Application
import com.bosta.task.BuildConfig
import com.bosta.task.di.networkModule
import com.bosta.task.di.repositoriesModule
import com.bosta.task.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class BostaTaskApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@BostaTaskApplication)
            modules(listOf(networkModule, viewModelModule, repositoriesModule))
        }
    }

    private fun initTimber() {
        Timber.plant(object : Timber.DebugTree() {
            override fun createStackElementTag(element: StackTraceElement): String {
                return super.createStackElementTag(element) + "line: " + element.lineNumber
            }
        })
    }
}