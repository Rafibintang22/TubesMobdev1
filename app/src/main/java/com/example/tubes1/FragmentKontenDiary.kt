package com.example.tubes1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tubes1.databinding.FragmentKontenDiaryBinding

class FragmentKontenDiary : Fragment() {
    lateinit var binding : FragmentKontenDiaryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentKontenDiaryBinding.inflate(inflater, container, false)

        return this.binding.root
    }
}