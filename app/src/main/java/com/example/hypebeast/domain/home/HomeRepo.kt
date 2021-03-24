package com.example.hypebeast.domain.home

import com.example.hypebeast.core.Result
import com.example.hypebeast.data.model.home.news

interface HomeRepo {
    suspend fun getLatestNews(): Result<List<news>>
}