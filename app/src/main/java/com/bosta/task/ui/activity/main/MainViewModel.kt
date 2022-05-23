package com.bosta.task.ui.activity.main

import androidx.databinding.ObservableBoolean
import com.bosta.task.base.BaseViewModel
import com.bosta.task.data.DataSourceManager

class MainViewModel(dataManager: DataSourceManager) : BaseViewModel(dataManager) {

    var showProgressBar = ObservableBoolean()
}