package com.example.tubes1

import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.InputFilter
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.tubes1.databinding.FragmentEditKontenBinding
import com.google.android.material.snackbar.Snackbar

class FragmentEditKonten : Fragment() {
    lateinit var binding: FragmentEditKontenBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var intentLauncher: ActivityResultLauncher<Intent>
    var imageUri: Uri? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentEditKontenBinding.inflate(inflater,container,false)
        this.viewModel = (activity as MainActivity).viewModel
        val view = this.binding.root
        val back = this.binding.btnBack
        val update = this.binding.buttonUpdate

        val maxLength = 18
        val filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxLength))
        this.binding.newTitle.filters = filters
        val buttonUpload = binding.uploadButton

        update.setOnClickListener{
            val title = this.binding.newTitle.text.toString()
            val story = this.binding.newStory.text.toString()

            Log.d("tesprint", title)
            Log.d("tesprint", story)

            if(title != ""){
                viewModel.diaryImage.value!!.setTitle(title)
            }

            if(story != ""){
                viewModel.diaryImage.value!!.setDesc(story)
            }

            // Perbarui properti imageUri pada DiaryImage
            viewModel.diaryImage.value!!.setUri(this.imageUri)
            viewModel.updatePage("Detail")

            val message = "Diary '${viewModel.diaryImage.value!!.getTitle()}' berhasil diedit"
            showSnackbar(message)
        }


        this.intentLauncher = this.registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){ result ->
            Log.d("tesprin", result.resultCode.toString())
            Log.d("tesprin", imageUri.toString())
            if(result.resultCode == AppCompatActivity.RESULT_OK){
                this.binding.image.setImageURI(imageUri)
            } else{
                imageUri = null
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

        back.setOnClickListener {
            viewModel.updatePage("Detail")
        }


        return view
    }
    private fun showSnackbar(message: String) {
        Snackbar.make(requireView(), message, Snackbar.LENGTH_SHORT).show()
    }
}