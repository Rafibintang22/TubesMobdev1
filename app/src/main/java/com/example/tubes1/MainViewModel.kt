package com.example.tubes1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var page: MutableLiveData<String> = MutableLiveData()
    var diaryImage: MutableLiveData<DiaryImage> = MutableLiveData()

    fun updateDiaryImg(img: DiaryImage){
        this.diaryImage.value = img
    }

    fun updatePage(page: String){
        this.page.value = page
    }

}