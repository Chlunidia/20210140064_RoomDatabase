package com.example.roomdatabase.model

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.roomdatabase.StudentsApp

fun CreationExtras.studentsApp(): StudentsApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as StudentsApp)