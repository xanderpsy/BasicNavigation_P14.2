package com.example.basicnavigation_p14.database

import androidx.room.Database
import androidx.room.RoomDatabase

const val Database_version = 1
const val TABLE_USERS = "users"
const val DATABASE_NAME = "myappname.sqlite"
@Database(
    entities =[UserEntity::class],
    version=Database_version,
    exportSchema = false
)
abstract class AppDatabase:RoomDatabase() {
    abstract fun userDao(): UserDao
}