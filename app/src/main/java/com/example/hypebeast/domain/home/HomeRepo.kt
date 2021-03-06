package com.example.hypebeast.domain.home

import com.example.hypebeast.core.Resource
import com.example.hypebeast.data.model.home.news

interface HomeRepo {
    suspend fun getLatestNews(): Resource<List<news>>
}