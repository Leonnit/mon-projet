package com.example.teste.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teste.data.local.dao.UserDao
import com.example.teste.data.local.entity.UserEntity
import com.example.teste.data.local.repository.UserRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class UserViewModel (private val repository: UserRepository) : ViewModel() {

    val user : StateFlow<List<UserEntity>> = repository.allUsers.map {
        it.sortedByDescending { user -> user.id }
    }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun insertUser(user: UserEntity) = viewModelScope.launch {
        repository.insertUser(user)
    }
    fun deleteUser(user: UserEntity) = viewModelScope.launch {
        repository.deleteUser(user)
    }
    fun updateUser(user: UserEntity) = viewModelScope.launch {
        repository.updateUser(user)
    }

}