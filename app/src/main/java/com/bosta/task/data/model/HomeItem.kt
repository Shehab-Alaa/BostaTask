package com.bosta.task.data.model

import android.os.Parcelable
import com.bosta.task.base.BaseParcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomeItem(
    @SerializedName("id")
    var id: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("price")
    var price: Double,
    @SerializedName("brand")
    var brand: String,
    @SerializedName("image")
    var image: Int,
    @SerializedName("quantity")
    var quantity: Int,
    @SerializedName("sale")
    var sale: String,
    @SerializedName("color")
    var color: String,
    @SerializedName("size")
    var size: String,
    @SerializedName("material")
    var material: String,
    @SerializedName("item_weight")
    var itemWeight: Double,
    @SerializedName("rate")
    var rate: Int,
    @SerializedName("num_of_rates")
    var numOfRates: Int,
) : BaseParcelable, Parcelable {
    override fun unique(): Any = id

    fun getBestSellItemTitle() = "$title |"

    fun getSalePercentage() = "up to $sale off"

    fun getItemPriceInEGP() = "EGP$price"

    fun getItemBrand() = "Brand: $brand"

    fun getQuantityLeft() = "Only $quantity left in stock - order soon."

    fun getItemWeightInKilos() = "$itemWeight Kilograms"
}