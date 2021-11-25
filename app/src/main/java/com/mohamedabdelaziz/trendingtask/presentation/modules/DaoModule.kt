package com.mohamedabdelaziz.trendingtask.presentation.modules

import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.mohamedabdelaziz.trendingtask.data.datasource.local.dao.TrendingDao
import com.mohamedabdelaziz.trendingtask.domain.repositories.TrendingRepositoryLocal
import com.mohamedabdelaziz.trendingtask.data.repositoryimp.TrendingRepositoryLocalImp
import com.mohamedabdelaziz.trendingtask.data.datasource.local.dp.TrendingDataBase
import dagger.Module
import dagger.Provides

@Module
@InstallIn(SingletonComponent::class)
class DaoModule {

    @Provides
    @Singleton
    fun provideDao(trendingDataBase: TrendingDataBase): TrendingDao = trendingDataBase.trendingDao()

    @Singleton
    @Provides
    fun provideTrendingRepositoryLocal(trendingDao: TrendingDao): TrendingRepositoryLocal =
        TrendingRepositoryLocalImp(trendingDao)


}