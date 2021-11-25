package com.mohamedabdelaziz.trendingtask.data.datasource.local.dp

import androidx.room.Database
import com.mohamedabdelaziz.trendingtask.domain.entities.TrendingItemResponse
import androidx.room.TypeConverters
import androidx.room.RoomDatabase
import com.mohamedabdelaziz.trendingtask.data.datasource.local.dao.TrendingDao
import com.mohamedabdelaziz.trendingtask.data.datasource.local.converters.Converters

@Database(entities = [TrendingItemResponse::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class TrendingDataBase : RoomDatabase() {
    abstract fun trendingDao(): TrendingDao
}