package com.bosta.task.ui.fragment.main.home

import android.os.Bundle
import android.view.View
import com.bosta.task.base.BaseFragment
import com.bosta.task.data.model.HomeCategoryItem
import com.bosta.task.data.model.HomeItem
import com.bosta.task.databinding.FragmentHomeBinding
import com.bosta.task.util.exts.navigateSafe
import com.bosta.task.util.exts.observe
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val mViewModel: HomeViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewModel.apply {
            observe(mutableLiveData){
                when(it){
                    is HomeCategoryItem -> {}
                    is HomeItem -> navigateSafe(HomeFragmentDirections.actionHomeFragmentToItemDetailsFragment(it))
                }
            }
        }
    }
}