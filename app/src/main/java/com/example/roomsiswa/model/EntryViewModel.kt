package com.example.roomsiswa.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.roomsiswa.data.Siswa
import com.example.roomsiswa.repository.RepositorySiswa

class EntryViewModel(private val repositorySiswa: RepositorySiswa): ViewModel(){
    /**
     * Berisi status Siswa saat ini
     */
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set
    /** Fungsi untuk memvalidasi input */
    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa): Boolean {
        return with(uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }
}
/**
 * Mewakili status UI untuk siswa
 */
data class UIStateSiswa(
    val detailSiswa: DetailSiswa = DetailSiswa(),
    val inEntryValid: Boolean = false
)
data class DetailSiswa(
    val id: Int = 0,
    val nama: String = "",
    val alamat: String = "",
    val telpon: String = "",
)
/** Fungsi untuk mengkonversi data input ke data dalam tabel sesuai jenis datanya */
fun DetailSiswa.toSiswa(): Siswa = Siswa(
    id = id,
    nama = nama,
    alamat = alamat,
    telpon = telpon
)