package com.example.roomdatabase.model

import com.example.roomdatabase.data.Students

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

fun StudentDetails.toStudents(): Students = Students(
    id = id,
    name = name,
    address = address,
    telp = telp
)
