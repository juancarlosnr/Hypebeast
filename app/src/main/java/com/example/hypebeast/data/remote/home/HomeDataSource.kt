package com.example.hypebeast.data.remote.home

import com.example.hypebeast.core.Result
import com.example.hypebeast.data.model.home.news
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class HomeDataSource {

    suspend fun getLatestNews(): Result<List<news>> {
        val newsList = mutableListOf<news>()
        val querySnapshot = FirebaseFirestore.getInstance().collection("news").get().await()
        for(new in querySnapshot.documents){
            new.toObject(news::class.java)?.let { news ->
                newsList.add(news)
            }
        }
        return Result.Sucess(newsList)
    }
}