package com.bosta.task.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.bosta.task.BR
import com.bosta.task.util.exts.bindView

abstract class BaseActivity<B: ViewDataBinding, VM : ViewModel> : AppCompatActivity() {

    lateinit var binding: B
    protected abstract val mViewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindView()
        binding.setVariable(BR.viewModel, mViewModel)
    }
}