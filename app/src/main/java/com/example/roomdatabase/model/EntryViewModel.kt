package com.example.roomdatabase.model

class EntryViewModel {
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