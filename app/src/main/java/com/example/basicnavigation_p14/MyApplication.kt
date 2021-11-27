package com.example.basicnavigation_p14

import android.app.Application
import com.example.basicnavigation_p14.database.DatabaseManager

open class MyApplication: Application() {
    override fun onCreate(){
        DatabaseManager.instance.initializeDb(applicationContext)
        super.onCreate()
    }
}