package com.bosta.task.ui.fragment.main.details

import android.os.Bundle
import android.view.View
import com.bosta.task.base.BaseFragment
import com.bosta.task.databinding.FragmentItemDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ItemDetailsFragment : BaseFragment<FragmentItemDetailsBinding, ItemDetailsViewModel>() {

    override val mViewModel: ItemDetailsViewModel by viewModel()
    private lateinit var args: ItemDetailsFragmentArgs

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewModel.apply {
            arguments?.let {
                args = ItemDetailsFragmentArgs.fromBundle(it)
                initArgs(args.homeItem)
            }
        }
    }
}