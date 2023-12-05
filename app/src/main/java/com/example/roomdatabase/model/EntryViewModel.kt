package com.example.roomdatabase.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.roomdatabase.data.Students
import com.example.roomdatabase.repository.StudentsRepository

class EntryViewModel(private val studentsRepository: StudentsRepository): ViewModel() {
    var uiStateStudents by mutableStateOf(StudentsUIState())
        private set

    private fun inputValidation(uiState: StudentDetails = uiStateStudents.studentDetails): Boolean {
        return with(uiState) {
            name.isNotBlank() && address.isNotBlank() && telp.isNotBlank()
        }
    }

    fun updateUIState(studentDetails: StudentDetails) {
        uiStateStudents = StudentsUIState(studentDetails = studentDetails, isEntryValid = inputValidation(studentDetails))
    }

    suspend fun saveStudents() {
        if (inputValidation()) {
            studentsRepository.insertStudent(uiStateStudents.studentDetails.toStudents())
        }
    }
}

data class StudentsUIState(
    val studentDetails: StudentDetails = StudentDetails(),
    val isEntryValid: Boolean = false
)

data class StudentDetails(
    val id: Int = 0,
    val name: String = "",
    val address: String = "",
    val telp: String = "",
)

fun StudentDetails.toStudents(): Students = Students(
    id = id,
    name = name,
    address = address,
    telp = telp
)

fun Students.toStudentsUIState(isEntryValid: Boolean = false): StudentsUIState = StudentsUIState(
    studentDetails = this.toStudentDetails(),
    isEntryValid = isEntryValid
)

fun Students.toStudentDetails(): StudentDetails = StudentDetails(
    id = id,
    name = name,
    address = address,
    telp = telp
)