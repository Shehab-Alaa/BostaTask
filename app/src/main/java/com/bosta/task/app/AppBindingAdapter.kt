package com.bosta.task.app

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Base64
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.widget.ContentLoadingProgressBar
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.request.CachePolicy
import com.bosta.task.R
import com.bosta.task.util.SpacesItemDecorationUtil
import com.bosta.task.util.exts.gone
import com.bosta.task.util.exts.isValidUrl
import com.bosta.task.util.exts.loadImageFromURL
import com.bosta.task.util.exts.visible
import com.bumptech.glide.Glide
import timber.log.Timber

@BindingAdapter(value = ["imageUrl"], requireAll = false)
fun setImageUrl(imageView: ImageView, url: String?) {
    imageView.load(url) {
        placeholder(R.drawable.loading)
        error(R.drawable.bg_default_image)
        memoryCachePolicy(CachePolicy.ENABLED)
    }
}

@BindingAdapter(value = ["loadImage", "imageLoader"], requireAll = false)
fun bindLoadImage(imageView: ImageView, obj: Any?, progressBar: ProgressBar?) {
    obj?.let {
        when (it) {
            is Int -> imageView.setImageResource(it)
            is Drawable -> imageView.setImageDrawable(it)
            is Bitmap -> imageView.setImageBitmap(it)
            is Uri -> imageView.setImageURI(it)
            is String -> when {
                it.isValidUrl() -> imageView.loadImageFromURL(it, progressBar)
                it.length >= 200 -> {
                    Timber.e("image is encoded")
                    val decodedString: ByteArray = Base64.decode(obj.toString(), Base64.DEFAULT)
                    Glide.with(imageView.context).asBitmap()
                        .load(decodedString)
                        .error(R.drawable.ic_broken_image)
                        .into(imageView)
                }
                else -> {
                    Timber.e("image string isn't valid")
                    imageView.loadImageFromURL("")
                }
            }
            else -> {
                Timber.e("image url isn't valid")
                imageView.loadImageFromURL("")
            }
        }
    } ?: imageView.loadImageFromURL("")
}

@BindingAdapter("adapter")
fun setRecyclerAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>?) {
    adapter?.let {
        recyclerView.adapter = it
        recyclerView.setHasFixedSize(true)
    }
}

@BindingAdapter("space")
fun setRecyclerItemDecoratorSpace(recyclerView: RecyclerView,space: Int) {
    recyclerView.addItemDecoration(SpacesItemDecorationUtil(space))
}


@BindingAdapter(value = ["isLoading"])
fun ContentLoadingProgressBar.show(isLoading: Boolean?) {
    if (isLoading == true) show() else hide()
}

@BindingAdapter("app:visibleGone")
fun bindViewGone(view: View, b: Boolean) {
    if (b) view.visible()
    else view.gone()
}

@BindingAdapter("setTvDrawableTopIcon")
fun setDrawableTopOnTextView(tv: TextView, icon: Int?) {
    icon?.let {
        tv.setCompoundDrawablesWithIntrinsicBounds(
            0,
            it,
            0,
            0
        )
    }
}

@BindingAdapter("imageResource")
fun setImageResource(imageView: ImageView, resource: Int) {
    imageView.setImageResource(resource)
}

@BindingAdapter("app:adapter", "app:setDivider")
fun bindAdapter(recyclerView: RecyclerView, adapter: ListAdapter<*, *>?, divider: Boolean?) {
    adapter?.let {
        recyclerView.adapter = it
        divider?.let { div ->
            if (div) {
                val decoration =
                    DividerItemDecoration(recyclerView.context, LinearLayoutManager.VERTICAL)
                recyclerView.addItemDecoration(decoration)
            }
        }
    } ?: Timber.e("adapter is null")
}
