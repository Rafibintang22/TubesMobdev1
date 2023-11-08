package com.example.tubes1

import android.net.Uri

class DiaryImage(private var title: String, private var desc: String, private var uri: Uri) {

    fun getTitle(): String{
        return this.title
    }

    fun getDesc(): String{
        return this.desc
    }

    fun getUri(): Uri{
        return this.uri
    }
}