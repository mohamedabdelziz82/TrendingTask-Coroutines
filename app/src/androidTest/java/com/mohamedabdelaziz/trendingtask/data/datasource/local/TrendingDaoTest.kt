package com.mohamedabdelaziz.trendingtask.data.datasource.local

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mohamedabdelaziz.trendingtask.domain.entities.TrendingItemResponse
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.ArrayList

@RunWith(AndroidJUnit4ClassRunner::class)
class TrendingDaoTest : TrendingDataBaseTest() {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun insertTrendingTest() {
        val trendingResponse1 = TrendingItemResponse()
        val trendingResponse2 = TrendingItemResponse()
        val trendingResponse3 = TrendingItemResponse()
        val trendingResponse4 = TrendingItemResponse()
        val trendingItemResponseList: MutableList<TrendingItemResponse?> = ArrayList()
        trendingItemResponseList.add(trendingResponse1)
        trendingItemResponseList.add(trendingResponse2)
        trendingItemResponseList.add(trendingResponse3)
        trendingItemResponseList.add(trendingResponse4)

        appDatabase.trendingDao().insertTrendingList(trendingItemResponseList)
        appDatabase.trendingDao().getAllTrendingFromDB().observeForever { trendingList ->
            Assert.assertEquals(trendingList?.size!!, 4)
        }
    }

    @Test
    fun deleteTrendingTest() {
        appDatabase.trendingDao().deleteAllTrendingList()
        appDatabase.trendingDao().getAllTrendingFromDB()
            .observeForever { trendingList -> Assert.assertEquals(trendingList?.size!!, 0) }
    }
}