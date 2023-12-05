package com.example.roomdatabase.repository

import com.example.roomdatabase.data.Students
import kotlinx.coroutines.flow.Flow

interface StudentsRepository {
    fun getAllStudentsStream(): Flow<List<Students>>

    fun getStudentsStream(id: Int): Flow<Students?>

    suspend fun insertStudent(students: Students)

    suspend fun deleteStudent(students: Students)

    suspend fun updateStudent(students: Students)
}