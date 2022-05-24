package com.bosta.task.util

import com.bosta.task.R

object LocalImagesUtil {

    private val imagesRes = hashMapOf(
        1 to R.drawable.ic_coupons,
        2 to R.drawable.ic_electronics,
        3 to R.drawable.ic_sports,
        4 to R.drawable.ic_clothes,
        5 to R.drawable.ic_phone,
        6 to R.drawable.ic_camera_temp_img,
        7 to R.drawable.ic_laptop,
        8 to R.drawable.ic_tv,
        9 to R.drawable.ic_mixer,
        10 to R.drawable.ic_refrigerator,
        11 to R.drawable.ic_oven,
        12 to R.drawable.ic_microwave
    )

    fun getImageRes(imgId: Int) = imagesRes[imgId] ?: R.drawable.ic_camera_temp_img
}