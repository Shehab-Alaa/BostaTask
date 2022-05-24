package com.bosta.task.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.bosta.task.BR
import com.bosta.task.util.Codes.BACK_BUTTON_PRESSED
import com.bosta.task.util.Status
import com.bosta.task.util.exts.bindView
import com.bosta.task.util.exts.observe
import com.bosta.task.util.exts.showKeyboard

abstract class BaseFragment<B :ViewDataBinding, VM : ViewModel> : Fragment() {
    lateinit var binding: B
    protected abstract val mViewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = bindView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setVariable(BR.viewModel, mViewModel)

        (mViewModel as BaseViewModel).apply {
            observe(mutableLiveData){
                when(it){
                    BACK_BUTTON_PRESSED -> requireActivity().onBackPressed()
                }
            }
            observe(resultLiveData){
                when(it?.status){
                    Status.LOADING -> closeKeyboard()
                    else -> {}
                }
            }
        }
    }

    private fun closeKeyboard(){
        showKeyboard(false)
    }

    override fun onPause() {
        super.onPause()
        closeKeyboard()
    }
}