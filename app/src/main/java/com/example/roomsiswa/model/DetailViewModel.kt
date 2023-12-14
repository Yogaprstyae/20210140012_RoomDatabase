package com.example.roomsiswa.model

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomsiswa.repository.RepositorySiswa
import com.example.roomsiswa.ui.theme.halaman.DetailsDestination
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositorySiswa: RepositorySiswa
): ViewModel(){
    private val siswaId: Int = checkNotNull(savedStateHandle[DetailsDestination.siswaIdArg])
    val uiState: StateFlow<ItemDetailsUIState> =
        repositorySiswa.getSiswaStream(siswaId)
            .filterNotNull()
            .map {
                ItemDetailsUIState(detailSiswa = it.toDetailSiswa())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIME_MILLIS),
                initialValue = ItemDetailsUIState()
            )
    suspend fun deleteItem(){
        repositorySiswa.deleteSiswa(uiState.value.detailSiswa.toSiswa())
    }
    companion object{
        private const val TIME_MILLIS = 5_000L
    }
}

data class ItemDetailsUIState(
    val outOfStock: Boolean = true,
    val detailSiswa: DetailSiswa = DetailSiswa()
)