package com.example.hypebeast.domain.sneakers

import com.example.hypebeast.core.Result
import com.example.hypebeast.data.model.sneakers.sneakers
import com.example.hypebeast.data.remote.sneakers.SneakersDataSource

class SneakersRepoImpl(private val dataSource: SneakersDataSource): SneakersRepo {
    override suspend fun getLatestSneakers(): Result<List<sneakers>> = dataSource.getLatestSneakers()
}