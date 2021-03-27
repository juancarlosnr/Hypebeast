package com.example.hypebeast.data.remote.sneakers

import com.example.hypebeast.core.Result
import com.example.hypebeast.data.model.sneakers.sneakers
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class SneakersDataSource {

    suspend fun getLatestSneakers(): Result<List<sneakers>> {
        val sneakersList = mutableListOf<sneakers>()
        val querySnapshot = FirebaseFirestore.getInstance().collection("sneakers").get().await()

        for (sneaker in querySnapshot.documents){
            sneaker.toObject(sneakers::class.java)?.let { sneakers ->
                sneakersList.add(sneakers)
            }
        }
        return Result.Sucess(sneakersList)
    }
}