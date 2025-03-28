package com.example.tubes1

import android.net.Uri

class DiaryImage(private var title: String, private var desc: String, private var uri: Uri, private var time: String) {

    fun getTitle(): String{
        return this.title
    }

    fun getTime(): String{
        return this.time
    }
    fun getDesc(): String{
        return this.desc
    }

    fun getUri(): Uri{
        return this.uri
    }

    fun setTitle(title: String){
        this.title = title
    }

    fun setDesc(desc: String){
        this.desc = desc
    }

    fun setUri(uri: Uri?){
        if (uri != null) {
            this.uri = uri
        }
    }
}