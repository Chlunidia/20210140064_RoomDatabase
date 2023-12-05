package com.example.roomdatabase.repository

import com.example.roomdatabase.data.Students
import com.example.roomdatabase.data.StudentsDao
import kotlinx.coroutines.flow.Flow

class OfflineStudentsRepository(private val studentsDao: StudentsDao) : StudentsRepository {
    override fun getAllStudentsStream(): Flow<List<Students>> = studentsDao.getAllStudents()

    override fun getStudentsStream(id: Int): Flow<Students?> {
        return studentsDao.getStudents(id)
    }

    override suspend fun insertStudent(students: Students) = studentsDao.insert(students)

    override suspend fun deleteStudent(students: Students) = studentsDao.delete(students)

    override suspend fun updateStudent(students: Students) {
        studentsDao.update(students)
    }
}