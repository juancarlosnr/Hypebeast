package com.example.hypebeast.core

import java.lang.Exception

sealed class Resource<out T>{
    class Loading<out T>: Resource<T>()
    data class Sucess<out T>(val data: T): Resource<T>()
    data class Failure(val exception: Exception): Resource<Nothing>()
}
