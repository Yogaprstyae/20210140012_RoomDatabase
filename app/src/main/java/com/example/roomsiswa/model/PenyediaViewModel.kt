package com.example.roomsiswa.model

import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiSiswa().container.repositorySiswa)
        }
        initializer {
            EntryViewModel(aplikasiSiswa().container.repositorySiswa)
        }
    }
}