package com.example.basicnavigation_p14.fragments

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basicnavigation_p14.database.DatabaseManager
import com.example.basicnavigation_p14.database.MyAppDataSorce
import com.example.basicnavigation_p14.database.User
import kotlinx.coroutines.launch

class DestinationViewModel: ViewModel() {
    val savedUsers = MutableLiveData<List<User>>()
   fun getUsers(){
       viewModelScope.launch {
           val userDao = DatabaseManager.instance.database.userDao()
           savedUsers.value = MyAppDataSorce(userDao).getUsers().value

       }
    }
}