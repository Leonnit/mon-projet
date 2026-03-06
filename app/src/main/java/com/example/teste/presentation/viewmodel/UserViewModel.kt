package com.example.teste.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teste.data.local.dao.UserDao
import com.example.teste.data.local.entity.UserEntity
import kotlinx.coroutines.launch

class UserViewModel () : ViewModel() {
    private lateinit var userDao: UserDao

    fun insertUser(name: String, lastname: String) {
        viewModelScope.launch {
            userDao.insertUser(
                UserEntity(name = name, firstname = lastname)
            )
        }
    }
}