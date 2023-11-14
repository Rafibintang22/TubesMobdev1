package com.example.tubes1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var page: MutableLiveData<String> = MutableLiveData()
    var diaryImage: MutableLiveData<DiaryImage> = MutableLiveData()
    var mode: MutableLiveData<Boolean> = MutableLiveData()
    var closeDrawers = MutableLiveData<Boolean>()
    var closeDrawer: LiveData<Boolean> = closeDrawers
    fun updateDiaryImg(img: DiaryImage){
        this.diaryImage.value = img
    }

    fun updatePage(page: String){
        this.page.value = page
    }

    fun updateMode(mode: Boolean){
        this.mode.value = mode
    }
    fun reqCloseDrawer(tutup: Boolean) {
        closeDrawers.value = tutup
    }
}