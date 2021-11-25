package com.mohamedabdelaziz.trendingtask.core.di

import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import android.app.Application
import com.mohamedabdelaziz.trendingtask.data.datasource.local.dp.TrendingDataBase
import androidx.room.Room
import dagger.Module
import dagger.Provides

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
        @Provides
        @Singleton
        fun provideDB(application: Application): TrendingDataBase = Room.databaseBuilder(application, TrendingDataBase::class.java, "trending_DB")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
}