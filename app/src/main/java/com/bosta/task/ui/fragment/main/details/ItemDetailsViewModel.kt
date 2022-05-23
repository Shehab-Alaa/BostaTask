package com.bosta.task.ui.fragment.main.details

import com.bosta.task.base.BaseViewModel
import com.bosta.task.data.DataSourceManager
import com.bosta.task.data.model.HomeItem

class ItemDetailsViewModel(dataManager: DataSourceManager) : BaseViewModel(dataManager)  {

    lateinit var homeItem: HomeItem

    fun initArgs(homeItem: HomeItem){
        this.homeItem = homeItem
    }

}