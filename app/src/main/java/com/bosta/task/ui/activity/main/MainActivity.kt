package com.bosta.task.ui.activity.main

import android.os.Bundle
import com.bosta.task.base.BaseActivity
import com.bosta.task.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding,MainViewModel>() {

    override val mViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewModel.apply {
            showProgressBar = baseShowProgress
        }
    }
}