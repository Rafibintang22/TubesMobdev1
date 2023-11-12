package com.example.myapplication

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.tubes1.DiaryImage
import com.example.tubes1.MainActivity
import com.example.tubes1.databinding.FragmentKontenDiaryBinding

class DiaryListAdapter(private val activity: MainActivity) : BaseAdapter() {
    private val viewModel = activity.viewModel
    private var images: MutableList<DiaryImage> = mutableListOf()
    lateinit var binding: FragmentKontenDiaryBinding

    fun addImage(img: DiaryImage){
        images.add(img)
        notifyDataSetChanged()
    }

    fun clearDiary(){
        images = mutableListOf()
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
//        val desc = binding.txtStoryDiary
        val tanggal = binding.txtTanggal
        val image = binding.imgDiary
        private lateinit var img: DiaryImage

        init{
            //agar dialog tiap view tdk dapat dibuka beberapa kali sekaligus
            view.setOnClickListener{
                viewModel.updateTitle(img.getTitle())
                viewModel.updateStory(img.getDesc())
                viewModel.updateImgUri(img.getUri())
                viewModel.updateTime(img.getTime())
                viewModel.updatePage("Detail")
            }
//            var openDialog = 1
//            view.setOnClickListener{
//                val dialog = Dialog(activity)
//                dialog.setContentView(R.layout.popup_fragment)
//
//                val photoView: PhotoView = dialog.findViewById(R.id.photo_view)
//                photoView.setImageURI(img.getUri())
//                dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//
//                photoView.setMinimumScale(0.5f) // You can adjust the minimum scale as needed
//                photoView.setMaximumScale(2.0f)
//
//                dialog.setOnDismissListener{
//                    openDialog++
//                }
//
//                if(openDialog == 1){
//                    dialog.show()
//                    openDialog--
//                }
//            }
        }

        fun updateView(img: DiaryImage){
            this.img = img
            title.text = img.getTitle()
//            desc.text = img.getDesc()
            tanggal.text = img.getTime()

            Log.d("test123", img.getUri().toString())
            image.setImageURI(img.getUri())
        }
    }

}