package com.mohamedabdelaziz.trendingtask.presentation.modules

import dagger.hilt.InstallIn
import javax.inject.Singleton
import com.mohamedabdelaziz.trendingtask.data.datasource.remote.ApiService
import com.mohamedabdelaziz.trendingtask.domain.repositories.TrendingRepositoryRemote
import com.mohamedabdelaziz.trendingtask.data.repositoryimp.TrendingRepositoryRemoteImp
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
@Module
@InstallIn(SingletonComponent::class)
class ApiServiceModule {
    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)


    @Singleton
    @Provides
    fun provideTrendingRepositoryRemote(apiService: ApiService): TrendingRepositoryRemote =
        TrendingRepositoryRemoteImp(apiService)

}