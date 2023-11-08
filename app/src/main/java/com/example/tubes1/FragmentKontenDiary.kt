package com.example.tubes1  

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tubes1.databinding.FragmentKontenDiaryBinding

class FragmentKontenDiary : Fragment() {
    lateinit var binding : FragmentKontenDiaryBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.viewModel = (activity as MainActivity).viewModel
        this.binding = FragmentKontenDiaryBinding.inflate(inflater, container, false)

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