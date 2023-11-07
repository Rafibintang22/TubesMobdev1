package com.example.tubes1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tubes1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(this.layoutInflater)
        this.viewModel = MainViewModel()
        setContentView(this.binding.root)
    }
}