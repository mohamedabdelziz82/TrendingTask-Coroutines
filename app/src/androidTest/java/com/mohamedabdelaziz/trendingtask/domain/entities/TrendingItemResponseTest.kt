package com.mohamedabdelaziz.trendingtask.domain.entities


import org.junit.Assert
import org.junit.Test
class TrendingItemResponseTest {
    @Test
    fun getAuthor()
       {
            val trendingResponse = TrendingItemResponse()
            trendingResponse.author = "Author"
            Assert.assertEquals("Author", trendingResponse.author)
        }

    @Test
    fun getName() {
            val trendingResponse = TrendingItemResponse()
            trendingResponse.name = "Name"
            Assert.assertEquals("Name", trendingResponse.name)
        }

    @Test
    fun getAvatar() {
            val trendingResponse = TrendingItemResponse()
            trendingResponse.avatar = "https://github.com/xingshaocheng.png"
            Assert.assertEquals("https://github.com/xingshaocheng.png", trendingResponse.avatar)
        }

    @Test
    fun getUrl() {
            val trendingResponse = TrendingItemResponse()
            trendingResponse.url = "https://github.com/xingshaocheng"
            Assert.assertEquals("https://github.com/xingshaocheng", trendingResponse.url)
        }

    @Test
    fun getDescription() {
            val trendingResponse = TrendingItemResponse()
            trendingResponse.description = "后端架构师技术图谱"
            Assert.assertEquals("后端架构师技术图谱", trendingResponse.description)
        }

    @Test
    fun getLanguage() {
            val trendingResponse = TrendingItemResponse()
            trendingResponse.language = "Go"
            Assert.assertEquals("Go", trendingResponse.language)
        }
}