package com.example.teste.data.local.repository

import com.example.teste.data.local.dao.UserDao
import com.example.teste.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {

    val allUsers: Flow<List<UserEntity>> = userDao.getAllUsers()

    suspend fun insertUser(todo: UserEntity) =userDao.insertUser(todo)
    suspend fun deleteUser(todo: UserEntity) =userDao.deleteUser(todo)
    suspend fun updateUser(todo: UserEntity) =userDao.insertUser(todo)



}