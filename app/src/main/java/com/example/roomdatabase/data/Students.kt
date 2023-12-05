package com.example.roomdatabase.data

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Room
import androidx.room.RoomDatabase

@Entity(tableName = "studentsTable")
data class Students(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val name : String,
    val address : String,
    val telp : String
)