package com.example.roomdatabase.repository

import android.content.Context
import com.example.roomdatabase.data.StudentsDatabase

interface ContainerApp {
    val studentsRepository : StudentsRepository
}

class ContainerDataApp(private val context: Context): ContainerApp {
    override val studentsRepository: StudentsRepository by lazy {
        OfflineStudentsRepository(StudentsDatabase.getDatabase(context).studentsDao())
    }
}