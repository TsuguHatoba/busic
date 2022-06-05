package com.example.busic.ui.buku

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.busic.data.PotterBukuItem
import com.example.busic.network.BukuApi
import kotlinx.coroutines.launch
import java.lang.Exception

enum class BukuApiStatus { LOADING, ERROR, DONE }

class BukuViewModel : ViewModel() {
    private val _status = MutableLiveData<BukuApiStatus>()
    val status: LiveData<BukuApiStatus> = _status

    private val _buku = MutableLiveData<List<PotterBukuItem>>()
    val buku: LiveData<List<PotterBukuItem>> = _buku

    private val _bukus = MutableLiveData<PotterBukuItem>()
    val bukus: LiveData<PotterBukuItem> = _bukus

    fun getBukuList() {
        viewModelScope.launch {
            _status.value = BukuApiStatus.LOADING
            try {
                _buku.value = BukuApi.retrofitBukuApi.getBuku()
                _status.value = BukuApiStatus.DONE
            } catch (e: Exception) {
                _buku.value = listOf()
                _status.value = BukuApiStatus.ERROR
                Log.e("Pesan Error :", "${e.message}")
            }
        }
    }

    fun onBukuClicked(buku: PotterBukuItem) {
        _bukus.value = buku
    }


}