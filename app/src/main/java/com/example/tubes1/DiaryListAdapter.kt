package com.example.myapplication

import android.os.Build
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.annotation.RequiresApi
import com.example.tubes1.DiaryImage
import com.example.tubes1.MainActivity
import com.example.tubes1.databinding.FragmentKontenDiaryBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DiaryListAdapter(private val activity: MainActivity) : BaseAdapter() {
    private var images: MutableList<DiaryImage> = mutableListOf()
    lateinit var binding: FragmentKontenDiaryBinding

    fun addImage(img: DiaryImage){
        images.add(img)
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun getItem(p0: Int): DiaryImage {
        return images[p0]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getView(i: Int, view: View?, viewGroup: ViewGroup?): View {
        var view :View? = view
        val viewHolder: ViewHolder
        if(view == null){
            this.binding = FragmentKontenDiaryBinding.inflate(activity.layoutInflater)
            view = binding.root
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else{
            viewHolder = view.tag as ViewHolder
        }

        viewHolder.updateView(getItem(i))
        return view
    }

    private inner class ViewHolder(view: View){
        val title = binding.txtJudulDiary
        val desc = binding.txtStoryDiary
        val tanggal = binding.txtTanggal
        val image = binding.imgDiary
        private lateinit var img: DiaryImage

        init{
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun updateView(img: DiaryImage){
            this.img = img
            title.text = img.getTitle()
            desc.text = img.getDesc()
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")
            val current = LocalDateTime.now().format(formatter)
            tanggal.text = current.toString()

            Log.d("test123", img.getDesc())
            image.setImageURI(img.getUri())
        }
    }

}