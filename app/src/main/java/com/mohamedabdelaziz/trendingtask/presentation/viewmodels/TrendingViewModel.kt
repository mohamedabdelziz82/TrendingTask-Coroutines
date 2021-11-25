package com.mohamedabdelaziz.trendingtask.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.mohamedabdelaziz.trendingtask.domain.entities.TrendingItemResponse
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.mohamedabdelaziz.trendingtask.domain.usecase.TrendingLocalUseCase
import com.mohamedabdelaziz.trendingtask.domain.usecase.TrendingRemoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrendingViewModel @Inject constructor(
    private var trendingRemoteUseCase: TrendingRemoteUseCase,
    private var trendingLocalUseCase: TrendingLocalUseCase
) : ViewModel() {
    var trendingResponseMutableLiveData = MutableLiveData<List<TrendingItemResponse>>()
    private lateinit var trendingLiveData: LiveData<List<TrendingItemResponse>>


    init {
        getTrendingListRemote()
    }

    private fun getTrendingListRemote() {
        viewModelScope.launch {
            trendingRemoteUseCase.invokeTrendingList().catch {
                Log.e(TAG, it.message!!)
            }.collect {
                trendingResponseMutableLiveData.value = it
                deleteAllTrendingList()
                insertTrendingList(it)

            }
        }

    }

    private suspend fun insertTrendingList(trendingListResponse: List<TrendingItemResponse>) {
        trendingLocalUseCase.insertTrending(trendingListResponse)
    }

    private suspend fun deleteAllTrendingList() {
        trendingLocalUseCase.deleteAllTrending()
    }

    fun getTrendingListLocal(): LiveData<List<TrendingItemResponse>> {
        trendingLiveData = trendingLocalUseCase.invokeTrendingList()
        return trendingLiveData
    }

    companion object {
        private const val TAG = "TrendingViewModel"
    }
}