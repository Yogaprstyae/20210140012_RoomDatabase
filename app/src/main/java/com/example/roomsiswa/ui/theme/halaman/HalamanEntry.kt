package com.example.roomsiswa.ui.theme.halaman

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.roomsiswa.model.DetailSiswa

@Composable
fun FormInputSiswa(
    detailSiswa: DetailSiswa,
    modifier: Modifier = Modifier,
    onValueChange: (DetailSiswa) -> Unit = {},
    enable: Boolean = true
){}