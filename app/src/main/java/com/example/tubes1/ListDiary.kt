package com.example.tubes1

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class ListDiary(private val activity: MainActivity) : BaseAdapter() {
    private val listDiary = ArrayList<Diary>()

    fun addDiary(diary: Diary){
        listDiary.add(diary)
    }
    override fun getCount(): Int {
        return listDiary.size
    }

    override fun getItem(position: Int): Diary {
        return listDiary[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        TODO("Not yet implemented")
    }
}