package com.mohamedabdelaziz.trendingtask.domain.repositories

import androidx.lifecycle.LiveData
import com.mohamedabdelaziz.trendingtask.domain.entities.TrendingItemResponse

interface TrendingRepositoryLocal {
    suspend fun insertTrendingList(trendingListResponse: List<TrendingItemResponse>)
    suspend fun deleteAllTrendingList()
      fun getTrendingList(): LiveData<List<TrendingItemResponse>>
}