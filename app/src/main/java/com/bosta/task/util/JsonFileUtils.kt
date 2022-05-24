package com.bosta.task.util

import android.content.Context
import com.bosta.task.data.model.HomeCategoryItem
import com.bosta.task.data.model.HomeItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

object JsonFileUtils {

    fun getCategoryLocalJsonResponse(app: Context,fileName: String): List<HomeCategoryItem> {
        val jsonFileString = getJsonDataFromAsset(app,fileName)
        val gson = Gson()
        val listItemType = object : TypeToken<List<HomeCategoryItem>>() {}.type
        return gson.fromJson(jsonFileString, listItemType)
    }

    fun getHomeLocalJsonResponse(app: Context,fileName: String): List<HomeItem> {
        val jsonFileString = getJsonDataFromAsset(app,fileName)
        val gson = Gson()
        val listItemType = object : TypeToken<List<HomeItem>>() {}.type
        return gson.fromJson(jsonFileString, listItemType)
    }

    private fun getJsonDataFromAsset(app: Context,fileName: String): String? {
        val jsonString: String
        try {
            jsonString = app.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}