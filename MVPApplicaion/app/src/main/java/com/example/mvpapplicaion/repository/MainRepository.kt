package com.example.mvpapplicaion.repository

interface MainRepository {
    fun getUser(): List<User>
}