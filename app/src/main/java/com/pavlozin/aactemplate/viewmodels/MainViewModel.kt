package com.pavlozin.aactemplate.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavlozin.aactemplate.data.MainModel
import com.pavlozin.aactemplate.data.MainRepository
import kotlinx.coroutines.launch

class MainViewModel internal constructor(private val repository: MainRepository) : ViewModel() {
    val data: LiveData<List<MainModel>> = repository.getData()

    fun createData(data: String) {
        viewModelScope.launch {
            repository.createData(data)
        }
    }

    fun deleteData() {
        viewModelScope.launch {
            repository.removeData()
        }
    }
}
