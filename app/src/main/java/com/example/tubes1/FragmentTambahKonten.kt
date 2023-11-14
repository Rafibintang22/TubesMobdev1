package com.example.tubes1

import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.text.InputFilter
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.DiaryListAdapter
import com.example.tubes1.databinding.FragmentTambahKontenBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class FragmentTambahKonten : Fragment() {
    private lateinit var binding: FragmentTambahKontenBinding
    private lateinit var intentLauncher: ActivityResultLauncher<Intent>
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: DiaryListAdapter
    var imageUri: Uri? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentTambahKontenBinding.inflate(inflater, container, false)
        this.viewModel = (activity as MainActivity).viewModel
        this.adapter = (activity as MainActivity).adapter
        val buttonBack = binding.btnBack

        val buttonUpload = binding.uploadButton
        val saveBtn = binding.buttonSave

        this.intentLauncher = this.registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){ result ->
            Log.d("test123", result.resultCode.toString())
            Log.d("test123", imageUri.toString())
            if(result.resultCode == AppCompatActivity.RESULT_OK){
                this.binding.image.setImageURI(imageUri)
            }
        }

        buttonUpload.setOnClickListener{
            val values = ContentValues()
            values.put(MediaStore.Images.Media.TITLE, "My Image")
            values.put(MediaStore.Images.Media.DESCRIPTION, "Image taken from my app")
            this.imageUri = requireActivity().contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)

            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
            this.intentLauncher.launch(takePictureIntent)
        }

        buttonBack.setOnClickListener {
            viewModel.updatePage("keHome")
        }

        //max character
        val maxLength = 18
        val filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxLength))
        this.binding.titleDiary.filters = filters

        saveBtn.setOnClickListener{
            val title = this.binding.titleDiary.text.toString()
            val desc = this.binding.descDiary.text.toString()
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")
            val current = LocalDateTime.now().format(formatter)
            if(title != "" && desc != "" && imageUri != null){
                adapter.addImage(DiaryImage(title, desc, imageUri!!, current.toString()))
                viewModel.updatePage("keHome")
            }
        }
        return this.binding.root
    }
}