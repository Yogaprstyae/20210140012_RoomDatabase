package com.example.roomsiswa.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomsiswa.data.Siswa
import com.example.roomsiswa.repository.RepositorySiswa
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HomeViewModel (private val repositorySiswa: RepositorySiswa): ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
    val homeUIState: StateFlow<HomeUIState> = repositorySiswa.getAllSiswaStream().filterNotNull()
        .map { HomeUIState(listSiswa = it.toList()) }
        .stateIn(scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = HomeUIState()
        )
    data class HomeUIState(
        val listSiswa: List<Siswa> = listOf()
    )
}