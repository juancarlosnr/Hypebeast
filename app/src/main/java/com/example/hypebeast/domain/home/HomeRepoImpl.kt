package com.example.hypebeast.domain.home

import com.example.hypebeast.core.Result
import com.example.hypebeast.data.model.home.news
import com.example.hypebeast.data.remote.home.HomeDataSource

class HomeRepoImpl(private val dataSource: HomeDataSource): HomeRepo {
    override suspend fun getLatestNews(): Result<List<news>> = dataSource.getLatestNews()
}