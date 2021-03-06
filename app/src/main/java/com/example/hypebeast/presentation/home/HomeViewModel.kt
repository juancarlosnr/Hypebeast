package com.example.hypebeast.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.hypebeast.core.Resource
import com.example.hypebeast.domain.home.HomeRepo
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class HomeViewModel(private val repo: HomeRepo): ViewModel() {
    fun fecthLatestNews() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getLatestNews())
        }catch (e:Exception){
            emit(Resource.Failure(e))
        }
    }
}

class HomeViewModelFactory(private val repo: HomeRepo):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(HomeRepo::class.java).newInstance(repo)
    }
}