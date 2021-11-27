package com.example.basicnavigation_p14.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basicnavigation_p14.database.DatabaseManager
import com.example.basicnavigation_p14.database.MyAppDataSorce
import com.example.basicnavigation_p14.database.User
import kotlinx.coroutines.launch

class LeftViewModel:ViewModel() {
    fun save(user: User){
        viewModelScope.launch{
            val userDao = DatabaseManager.instance.database.userDao()
        MyAppDataSorce(userDao).save(user)
        }
    }
}