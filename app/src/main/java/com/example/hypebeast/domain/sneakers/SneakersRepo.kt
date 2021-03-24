package com.example.hypebeast.domain.sneakers

import com.example.hypebeast.core.Result
import com.example.hypebeast.data.model.sneakers.sneakers

interface SneakersRepo {
    suspend fun getLatestSneakers(): Result<List<sneakers>>
}