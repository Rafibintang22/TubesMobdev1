package com.example.tubes1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tubes1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(this.layoutInflater)

        setContentView(this.binding.root)
    }
}