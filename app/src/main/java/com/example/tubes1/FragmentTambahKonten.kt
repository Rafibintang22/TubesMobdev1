package com.example.tubes1

import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.tubes1.databinding.FragmentTambahKontenBinding

class FragmentTambahKonten : Fragment() {
    lateinit var binding: FragmentTambahKontenBinding
    lateinit var intentLauncher: ActivityResultLauncher<Intent>
    var imageUri: Uri? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentTambahKontenBinding.inflate(inflater, container, false)

        val buttonBack = binding.btnBack
        buttonBack.setOnClickListener {
            pindahkeFragment(FragmentHome())
        }

        val buttonSave = binding.buttonSave
        buttonSave.setOnClickListener {
            pindahkeFragment(FragmentHome())
        }

        val buttonUpload = binding.uploadButton
        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE, "My Image")
        values.put(MediaStore.Images.Media.DESCRIPTION, "Image taken from my app")
        this.imageUri = requireActivity().contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)

        this.intentLauncher = this.registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){ result ->
            if(result.resultCode == AppCompatActivity.RESULT_OK){
                this.binding.image.setImageURI(imageUri)
            }
        }

        buttonUpload.setOnClickListener{
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
            this.intentLauncher.launch(takePictureIntent)
        }
        
        return this.binding.root
    }

    fun pindahkeFragment(fragmentBaru : Fragment){
        val mainActivity = activity as MainActivity

        val fragmentTransaction = mainActivity.supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragmentBaru)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}