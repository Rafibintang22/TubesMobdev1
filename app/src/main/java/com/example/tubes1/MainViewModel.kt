package com.example.tubes1

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var title: MutableLiveData<String> = MutableLiveData()
    var story: MutableLiveData<String> = MutableLiveData()
    var imgUri: MutableLiveData<Uri> = MutableLiveData()
    var time: MutableLiveData<String> = MutableLiveData()
    var page: MutableLiveData<String> = MutableLiveData()

    fun updateTitle(title: String){
        this.title.value = title
    }

    fun updateStory(story: String){
        this.story.value = story
    }

    fun updateImgUri(uri: Uri){
        this.imgUri.value = uri
    }

    fun updateTime(time: String){
        this.time.value = time
    }

    fun updatePage(page: String){
        this.page.value = page
    }

}