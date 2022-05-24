package com.bosta.task.app

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bosta.task.util.LocalImagesUtil
import com.bosta.task.util.exts.gone
import com.bosta.task.util.exts.visible

@BindingAdapter("adapter")
fun setRecyclerAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>?) {
    adapter?.let {
        recyclerView.adapter = it
        recyclerView.setHasFixedSize(true)
    }
}

@BindingAdapter("app:visibleGone")
fun bindViewGone(view: View, b: Boolean) {
    if (b) view.visible()
    else view.gone()
}

@BindingAdapter("imageRes")
fun setImageRes(imageView: ImageView, imgId: Int) {
    imageView.setImageResource(LocalImagesUtil.getImageRes(imgId))
}