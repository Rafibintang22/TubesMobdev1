package com.example.tubes1

import android.os.Bundle
import android.text.InputFilter
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tubes1.databinding.FragmentEditKontenBinding

class FragmentEditKonten : Fragment() {
    lateinit var binding: FragmentEditKontenBinding
    private lateinit var viewModel: MainViewModel
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
            viewModel.updatePage("Detail")
        }

        back.setOnClickListener {
            viewModel.updatePage("Detail")
        }


        return view
    }
    fun pindahKeFragment(fragment: Fragment){
        val mainActivity = activity as MainActivity
        val fragmentTransaction = mainActivity.supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}