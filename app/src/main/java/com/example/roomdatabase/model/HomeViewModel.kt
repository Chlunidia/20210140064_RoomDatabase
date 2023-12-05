package com.example.roomdatabase.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdatabase.data.Students
import com.example.roomdatabase.repository.StudentsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HomeViewModel (private val studentsRepository: StudentsRepository): ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}