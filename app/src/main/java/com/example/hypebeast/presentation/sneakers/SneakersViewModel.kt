package com.example.hypebeast.presentation.sneakers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.hypebeast.core.Result
import com.example.hypebeast.domain.sneakers.SneakersRepo
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class SneakersViewModel(private val repo: SneakersRepo):ViewModel() {
    fun fetchLatestSneakers() = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(repo.getLatestSneakers())
        }catch (e:Exception){
            emit(Result.Failure(e))
        }
    }
}
class SneakersViewModelFactory(private val repo:SneakersRepo):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return modelClass.getConstructor(SneakersRepo::class.java).newInstance(repo)
    }
}