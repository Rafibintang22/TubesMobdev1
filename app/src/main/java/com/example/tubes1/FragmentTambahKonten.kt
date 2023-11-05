package com.example.tubes1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tubes1.databinding.FragmentTambahKontenBinding

class FragmentTambahKonten : Fragment() {
    lateinit var binding: FragmentTambahKontenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentTambahKontenBinding.inflate(inflater, container, false)

        return this.binding.root
    }
}