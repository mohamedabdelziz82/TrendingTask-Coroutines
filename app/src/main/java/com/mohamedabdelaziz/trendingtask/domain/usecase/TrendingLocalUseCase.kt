package com.mohamedabdelaziz.trendingtask.domain.usecase


import androidx.lifecycle.LiveData
import com.mohamedabdelaziz.trendingtask.domain.entities.TrendingItemResponse
import javax.inject.Inject
import com.mohamedabdelaziz.trendingtask.domain.repositories.TrendingRepositoryLocal


class TrendingLocalUseCase @Inject constructor(private var repository: TrendingRepositoryLocal){
      fun invokeTrendingList(): LiveData<List<TrendingItemResponse>> =repository.getTrendingList()
    suspend fun insertTrending(trendingListResponse: List<TrendingItemResponse>) {
        repository.insertTrendingList(trendingListResponse)
    }
    suspend  fun deleteAllTrending(){
        repository.deleteAllTrendingList()
    }
}
