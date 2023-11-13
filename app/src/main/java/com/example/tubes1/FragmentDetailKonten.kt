package com.example.tubes1

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.tubes1.databinding.FragmentDetailKontenBinding
import com.github.chrisbanes.photoview.PhotoView

class FragmentDetailKonten : Fragment() {
    lateinit var binding : FragmentDetailKontenBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.viewModel = (activity as MainActivity).viewModel
        this.binding = FragmentDetailKontenBinding.inflate(inflater, container, false)

        val editBtn = this.binding.btnEdit
        val backBtn = this.binding.btnBack
        val delBtn = this.binding.delBtn

        viewModel.diaryImage.observe(viewLifecycleOwner,{
                img: DiaryImage -> loadDetail(viewModel.diaryImage.value)
        })

        editBtn.setOnClickListener{
            viewModel.updatePage("keEdit")
        }

        backBtn.setOnClickListener {
            viewModel.updatePage("keHome")
        }

        delBtn.setOnClickListener{
            (activity as MainActivity).adapter.delImage(viewModel.diaryImage.value!!)
        }
        return this.binding.root
    }

    fun loadDetail(image: DiaryImage?){
        val img = image!!
        this.binding.judulDetail.text = "Story Of " + img.getTitle()
        this.binding.storyDetail.text = img.getDesc()
        this.binding.dateCreated.text = "Created On " + img.getTime()
        this.binding.imgDiary.setImageURI(img.getUri())
        this.binding.imgDiary.setOnClickListener {
            lihatPhoto()
        }
    }

    fun lihatPhoto(){
        var openDialog = 1
        val dialog = Dialog((activity as MainActivity))
        dialog.setContentView(R.layout.popup_fragment)

        val photoView: PhotoView = dialog.findViewById(R.id.photo_view)
        val closeBtn: ImageButton = dialog.findViewById(R.id.btn_close)
        photoView.setImageURI(viewModel.diaryImage.value!!.getUri())
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        photoView.setMinimumScale(0.5f) // You can adjust the minimum scale as needed
        photoView.setMaximumScale(2.0f)

        dialog.setOnDismissListener{
            openDialog++
        }

        closeBtn.setOnClickListener{
            dialog.dismiss()
        }

        if(openDialog == 1){
            dialog.show()
            openDialog--
        }
    }
}