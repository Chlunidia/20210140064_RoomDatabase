package com.example.roomdatabase

import android.app.Application
import com.example.roomdatabase.repository.ContainerApp
import com.example.roomdatabase.repository.ContainerDataApp

class StudentsApp : Application() {
    lateinit var container: ContainerApp
    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}