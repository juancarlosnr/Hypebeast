package com.example.hypebeast.domain.auth

import com.google.firebase.auth.FirebaseUser

interface AuthRepo {
    suspend fun signIn(email:String, password:String):FirebaseUser?
    suspend fun signUp(email: String, password: String, username: String): FirebaseUser?
}