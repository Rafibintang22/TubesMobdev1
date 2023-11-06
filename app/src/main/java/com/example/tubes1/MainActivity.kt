package com.example.tubes1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.tubes1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(this.layoutInflater)
        setContentView(this.binding.root)

        val toolbar = this.binding.toolbar
        this.setSupportActionBar(toolbar)

        val drawer = this.binding.drawerLayout
        val hamburger = ActionBarDrawerToggle(this, drawer,toolbar,R.string.openDrawer, R.string.closeDrawer)
        drawer.addDrawerListener(hamburger)
        hamburger.syncState()


    }
}