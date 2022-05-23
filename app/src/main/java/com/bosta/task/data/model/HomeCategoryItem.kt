package com.bosta.task.data.model

import android.os.Parcelable
import com.bosta.task.base.BaseParcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomeCategoryItem(
    @SerializedName("id")
    var id: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("image")
    var image: Int,
    ) : BaseParcelable, Parcelable {
    override fun unique(): Any = id
}