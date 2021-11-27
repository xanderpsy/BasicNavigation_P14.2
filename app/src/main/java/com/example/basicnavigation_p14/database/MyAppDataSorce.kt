package com.example.basicnavigation_p14.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyAppDataSorce(private val userDao: UserDao) {
    suspend fun getUsers(): LiveData<List<User>> = withContext(Dispatchers.IO){
        return@withContext MutableLiveData(userDao.getUserFromDatabase().map {it.toUSer()})
    }

    suspend fun getSingleUser(query: String): LiveData<User> = withContext(Dispatchers.IO){
        return@withContext MutableLiveData(userDao.getUserByUsername(query).toUSer())
    }
    suspend fun delete(user:User) = withContext(Dispatchers.IO){
        userDao.delete(user.toEntity())
    }
    suspend fun save(user:User) =  withContext(Dispatchers.IO){
        userDao.save(user.toEntity())
    }
}