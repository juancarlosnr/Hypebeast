package com.example.hypebeast.domain.sneakers

import com.example.hypebeast.core.Resource
import com.example.hypebeast.data.model.sneakers.sneakers

interface SneakersRepo {
    suspend fun getLatestSneakers(): Resource<List<sneakers>>
}