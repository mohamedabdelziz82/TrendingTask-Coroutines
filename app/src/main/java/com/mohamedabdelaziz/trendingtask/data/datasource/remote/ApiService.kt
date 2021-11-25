package com.mohamedabdelaziz.trendingtask.data.datasource.remote

import retrofit2.http.GET
import com.mohamedabdelaziz.trendingtask.domain.entities.TrendingItemResponse
interface ApiService {
    @GET("repositories")
    suspend fun getApiTrendingRepositoriesList(): List<TrendingItemResponse>
}