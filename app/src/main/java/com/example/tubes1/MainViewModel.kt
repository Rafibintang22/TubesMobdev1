package com.example.tubes1

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var title: MutableLiveData<String> = MutableLiveData()
    var story: MutableLiveData<String> = MutableLiveData()
    var imgUri: MutableLiveData<Uri> = MutableLiveData()

    fun updateTitle(title: String){
        this.title.value = title
    }

    fun updateMessage(story: String){
        this.story.value = story
    }

    fun updateImgUri(uri: Uri){
        this.imgUri.value = uri
    }
}