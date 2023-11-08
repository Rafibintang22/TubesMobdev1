package com.example.tubes1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.DiaryListAdapter
import com.example.tubes1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    lateinit var adapter: DiaryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(this.layoutInflater)
        this.adapter = DiaryListAdapter(this)
        this.viewModel = MainViewModel()
        setContentView(this.binding.root)
    }
}