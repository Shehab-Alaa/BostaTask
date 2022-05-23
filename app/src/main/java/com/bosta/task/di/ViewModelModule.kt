package com.bosta.task.di

import com.bosta.task.ui.activity.main.MainViewModel
import com.bosta.task.ui.fragment.main.details.ItemDetailsViewModel
import com.bosta.task.ui.fragment.main.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { MainViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { ItemDetailsViewModel(get()) }
}

