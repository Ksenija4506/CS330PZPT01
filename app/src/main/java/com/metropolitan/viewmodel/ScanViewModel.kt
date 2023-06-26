package com.metropolitan.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScanViewModel : ViewModel() {

    private val _qrCodeValue = MutableLiveData<String>()
    val qrCodeValue: LiveData<String> get() = _qrCodeValue

    fun onScanResult(value: String) {
        _qrCodeValue.value = value
    }
}