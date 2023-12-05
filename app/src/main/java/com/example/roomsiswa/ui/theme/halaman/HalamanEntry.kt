package com.example.roomsiswa.ui.theme.halaman

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.example.roomsiswa.R
import com.example.roomsiswa.model.DetailSiswa

@Composable
fun FormInputSiswa(
    detailSiswa: DetailSiswa,
    modifier: Modifier = Modifier,
    onValueChange: (DetailSiswa) -> Unit = {},
    enable: Boolean = true
){
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
    ){
        OutlinedTextField(
            value = detailSiswa.nama,
            onValueChange = {onValueChange(detailSiswa.copy(nama = it))},
            label = { Text(stringResource(R.string.nama))},
            modifier = modifier.fillMaxWidth(),
            enable = enable,
            singleLine = true
        )
        OutlinedTextField(
            value = detailSiswa.alamat,
            onValueChange = {onValueChange(detailSiswa.copy(alamat = it))},
            label = { Text(stringResource(R.string.alamat))},
            modifier = modifier.fillMaxWidth(),
            enable = enable,
            singleLine = true
        )
        OutlinedTextField(
            value = detailSiswa.telpon,
            onValueChange = {onValueChange(detailSiswa.copy(telpon = it))},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(stringResource(R.string.nama))},
            modifier = modifier.fillMaxWidth(),
            enable = enable,
            singleLine = true
        )
        if (enable){
            Text(text = stringResource(R.string.required_field),
                modifier = modifier.padding(start = dimensionResource(id = R.dimen.padding_medium))
            )
        }
    }
}