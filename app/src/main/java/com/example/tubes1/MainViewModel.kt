package com.example.tubes1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var page: MutableLiveData<Int> = MutableLiveData()
    var message: MutableLiveData<String> = MutableLiveData()

    fun updatePage(page: Int){
        this.page.value = page
    }

    fun updateMessage(msg: String){
        this.message.value = msg
    }
}