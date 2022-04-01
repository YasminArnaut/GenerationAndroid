package com.example.room

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.room.data.User
import com.example.room.data.UserDataBase
import com.example.room.data.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(context: Context?): ViewModel() {

    val lerTodosOsDados: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao = UserDataBase.getDatebase(context!!).userDao()
        repository = UserRepository(userDao)
        lerTodosOsDados = repository.lerTodosOsDados
    }

    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO){
        repository.addUser(user)
    }
}
}