package com.example.roomdatabase.ui.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.example.roomdatabase.R
import com.example.roomdatabase.model.StudentDetails
import com.example.roomdatabase.model.StudentsUIState
import com.example.roomdatabase.navigation.NavigationDestination

object EntryDestination : NavigationDestination {
    override val route = "item_entry"
    override val titleRes = R.string.entry_siswa
}

@Composable
fun StudentsEntryBody(
    uiStateSiswa: StudentsUIState,
    onSiswaValueChange: (StudentDetails) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_large)),
        modifier = modifier.padding(dimensionResource(id = R.dimen.padding_medium))
    ) {
        StudentsInputForm(
            studentDetails = uiStateSiswa.studentDetails,
            onValueChange = onSiswaValueChange,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = onSaveClick,
            enabled = uiStateSiswa.isEntryValid,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.btn_submit))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentsInputForm(
    studentDetails: StudentDetails,
    modifier: Modifier = Modifier,
    onValueChange: (StudentDetails) -> Unit = {},
    enabled: Boolean = true
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
    ) {
        OutlinedTextField(
            value = studentDetails.name,
            onValueChange = { onValueChange(studentDetails.copy(name = it)) },
            label = { Text(stringResource(R.string.name)) },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = studentDetails.address,
            onValueChange = { onValueChange(studentDetails.copy(address = it)) },
            label = { Text(stringResource(R.string.address)) },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = studentDetails.telp,
            onValueChange = { onValueChange(studentDetails.copy(telp = it)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(text = stringResource(R.string.telp)) },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        if (enabled) {
            Text(
                text = stringResource(R.string.required_field),
                modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_medium))
            )
        }
        Divider(
            thickness = dimensionResource(R.dimen.padding_small),
            modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium))
        )
    }
}