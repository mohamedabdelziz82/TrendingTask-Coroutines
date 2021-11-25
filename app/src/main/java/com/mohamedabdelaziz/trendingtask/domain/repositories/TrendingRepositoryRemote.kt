package com.mohamedabdelaziz.trendingtask.domain.repositories

import com.mohamedabdelaziz.trendingtask.domain.entities.TrendingItemResponse
import kotlinx.coroutines.flow.Flow

interface TrendingRepositoryRemote {
    suspend fun getTrendingList(): Flow<List<TrendingItemResponse>>
}