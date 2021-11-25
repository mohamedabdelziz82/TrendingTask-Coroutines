package com.mohamedabdelaziz.trendingtask.data.repositoryimp

import javax.inject.Inject
import com.mohamedabdelaziz.trendingtask.data.datasource.remote.ApiService
import com.mohamedabdelaziz.trendingtask.domain.repositories.TrendingRepositoryRemote
import com.mohamedabdelaziz.trendingtask.domain.entities.TrendingItemResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.Dispatchers.IO
 import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * This repository is responsible for
 * fetching data from server
 */
class TrendingRepositoryRemoteImp @Inject constructor(private val apiService: ApiService) : TrendingRepositoryRemote {
       override suspend fun getTrendingList():  Flow<List<TrendingItemResponse>> = flow {
           emit(apiService.getApiTrendingRepositoriesList())
       }.flowOn(IO)
}