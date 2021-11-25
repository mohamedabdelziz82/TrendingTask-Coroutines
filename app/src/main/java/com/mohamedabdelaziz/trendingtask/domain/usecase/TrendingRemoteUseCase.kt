package com.mohamedabdelaziz.trendingtask.domain.usecase

import com.mohamedabdelaziz.trendingtask.domain.entities.TrendingItemResponse
import javax.inject.Inject
import com.mohamedabdelaziz.trendingtask.domain.repositories.TrendingRepositoryRemote
import kotlinx.coroutines.flow.Flow


class TrendingRemoteUseCase @Inject constructor(private var repository: TrendingRepositoryRemote){
    suspend fun invokeTrendingList(): Flow<List<TrendingItemResponse>> =repository.getTrendingList()

}