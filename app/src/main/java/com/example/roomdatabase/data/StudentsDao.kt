package com.example.roomdatabase.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(students: Students)

    @Update
    suspend fun update(students: Students)

    @Delete
    suspend fun delete(students: Students)

    @Query("SELECT * FROM studentsTable WHERE id = :id")
    fun getStudents(id: Int): Flow<Students>

    @Query("SELECT * FROM studentsTable ORDER BY name ASC")
    fun getAllStudents(): Flow<List<Students>>
}