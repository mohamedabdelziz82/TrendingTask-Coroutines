package com.mohamedabdelaziz.trendingtask.data.datasource.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mohamedabdelaziz.trendingtask.domain.entities.TrendingItemResponse
import java.util.ArrayList

class Converters {
    @TypeConverter
    fun fromBuiltByToGson(builtByList: List<TrendingItemResponse.BuiltBy>): String {
        return Gson().toJson(builtByList)
    }

    @TypeConverter
    fun fromGsonToBuiltBy(builtByString: String?): List<TrendingItemResponse.BuiltBy> {
        val listType = object : TypeToken<ArrayList<TrendingItemResponse.BuiltBy>>() {}.type
        return Gson().fromJson(builtByString, listType)
    }
}