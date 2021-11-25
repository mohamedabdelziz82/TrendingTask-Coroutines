package com.mohamedabdelaziz.trendingtask.data.repositoryimp


import javax.inject.Inject
import com.mohamedabdelaziz.trendingtask.data.datasource.local.dao.TrendingDao
import com.mohamedabdelaziz.trendingtask.domain.repositories.TrendingRepositoryLocal
import com.mohamedabdelaziz.trendingtask.domain.entities.TrendingItemResponse
import androidx.lifecycle.LiveData

/**
 * This repository is responsible for
 * fetching data from  db
 */
class TrendingRepositoryLocalImp @Inject constructor(private val trendingDao: TrendingDao) :
    TrendingRepositoryLocal {
    override suspend fun insertTrendingList(trendingListResponse: List<TrendingItemResponse>) {
        trendingDao.insertTrendingList(trendingListResponse)
    }

    override suspend fun deleteAllTrendingList() {
        trendingDao.deleteAllTrendingList()
    }

    override   fun getTrendingList(): LiveData<List<TrendingItemResponse>> {
        return trendingDao.getAllTrendingFromDB()
    }
}