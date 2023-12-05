package com.example.roomdatabase.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Students::class], version = 1, exportSchema = false)
abstract class StudentsDatabase : RoomDatabase() {
    abstract fun studentsDao(): StudentsDao

    companion object {
        @Volatile
        private var Instance: StudentsDatabase? = null

        fun getDatabase(context: Context): StudentsDatabase {
            return (Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    StudentsDatabase::class.java,
                    "students_database"
                )
                    .build().also { Instance = it }
            }
                    )
        }
    }
}