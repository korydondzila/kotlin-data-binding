package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(): ViewModel() {
    private val _selectedID = MutableLiveData<Int>()
    val selectedID: LiveData<Int> = _selectedID

    init {
        _selectedID.value = 1
    }

    fun toggle(optionID: Int) {
        _selectedID.value = optionID
    }
}
