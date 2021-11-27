package com.example.basicnavigation_p14.database

import androidx.room.*

@Dao
interface UserDao {
    @Delete
    fun delete(user:UserEntity)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(user:UserEntity)
    @Query("SELECT * FROM $TABLE_USERS")
    fun getUserFromDatabase():List<UserEntity>

    @Query("SELECT * FROM $TABLE_USERS WHERE username= :query")
    fun getUserByUsername(query:String):UserEntity
}