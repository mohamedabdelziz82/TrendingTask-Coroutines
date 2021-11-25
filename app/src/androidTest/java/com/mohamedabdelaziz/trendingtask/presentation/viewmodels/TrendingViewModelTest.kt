package com.mohamedabdelaziz.trendingtask.presentation.viewmodels

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.mohamedabdelaziz.trendingtask.data.datasource.local.TrendingDataBaseTest
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mohamedabdelaziz.trendingtask.data.datasource.local.dao.TrendingDao
import com.mohamedabdelaziz.trendingtask.data.datasource.remote.ApiService
import com.mohamedabdelaziz.trendingtask.data.repositoryimp.TrendingRepositoryLocalImp
import com.mohamedabdelaziz.trendingtask.data.repositoryimp.TrendingRepositoryRemoteImp
import com.mohamedabdelaziz.trendingtask.domain.entities.TrendingItemResponse
import com.mohamedabdelaziz.trendingtask.domain.repositories.TrendingRepositoryLocal
import com.mohamedabdelaziz.trendingtask.domain.repositories.TrendingRepositoryRemote
import com.mohamedabdelaziz.trendingtask.domain.usecase.TrendingLocalUseCase
import com.mohamedabdelaziz.trendingtask.domain.usecase.TrendingRemoteUseCase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import javax.inject.Inject

@RunWith(AndroidJUnit4ClassRunner::class)
class TrendingViewModelTest : TrendingDataBaseTest() {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private var viewModel: TrendingViewModel? = null

    private lateinit var apiService: ApiService

    lateinit var repositoryRemote: TrendingRepositoryRemoteImp

    lateinit var repositoryLocal: TrendingRepositoryLocalImp
    @Before
    fun init() {
        apiService = Retrofit.Builder()
            .baseUrl("https://private-anon-ff5114eef6-githubtrendingapi.apiary-mock.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
            .create(ApiService::class.java)
        val trendingDao: TrendingDao=appDatabase.trendingDao()
        repositoryRemote= TrendingRepositoryRemoteImp(apiService)
        repositoryLocal= TrendingRepositoryLocalImp(trendingDao)
       var trendingRemoteUseCase=TrendingRemoteUseCase(repositoryRemote)
       var trendingLocalUseCase =TrendingLocalUseCase(repositoryLocal)
        viewModel = TrendingViewModel(trendingRemoteUseCase!!, trendingLocalUseCase!!)
    }

    @Test
    fun testTrendingViewModel() {
        init()
        viewModel?.trendingResponseMutableLiveData?.observeForever { trending: List<TrendingItemResponse> ->
            Assert.assertEquals(
                trending.size.toLong(),
                4
            )
        }
    }
}