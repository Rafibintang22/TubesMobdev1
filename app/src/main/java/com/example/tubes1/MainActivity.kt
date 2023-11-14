package com.example.tubes1

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
import android.util.Log
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.myapplication.DiaryListAdapter
import com.example.tubes1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    lateinit var adapter: DiaryListAdapter
    lateinit var sharedPref: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.viewModel = MainViewModel()
        this.binding = ActivityMainBinding.inflate(this.layoutInflater)
        this.adapter = DiaryListAdapter(this)
        this.sharedPref = getPreferences(MODE_PRIVATE)
        setContentView(this.binding.root)
        Log.d("test123", "sudah masuk")

        val toolbar = this.binding.toolbar
        this.setSupportActionBar(toolbar)

        val drawer = this.binding.drawerLayout
        val hamburger = ActionBarDrawerToggle(this, drawer,toolbar,R.string.openDrawer, R.string.closeDrawer)
        drawer.addDrawerListener(hamburger)
        hamburger.syncState()

        viewModel.page.observe(this,{
                page: String -> changePage(page)
        })

        viewModel.mode.observe(this,{
                mode: Boolean -> changeMode(mode)
        })

        viewModel.closeDrawer.observe(this, {
            binding.drawerLayout.closeDrawers()
        })
    }

    private fun changeMode(mode : Boolean){
        Log.d("tesmode", mode.toString())
        if (mode == false){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
    }

    private fun changePage(page: String) {
        if(page == "Detail"){
            supportFragmentManager.commit {
                replace<FragmentDetailKonten>(R.id.fragment_container)
                addToBackStack(null)
            }
        } else if(page == "keTambahKonten"){
            supportFragmentManager.commit {
                replace<FragmentTambahKonten>(R.id.fragment_container)
                addToBackStack(null)
            }
        } else if(page == "keHome"){
            supportFragmentManager.commit {
                replace<FragmentHome>(R.id.fragment_container)
                addToBackStack(null)
            }
        }
        else if(page == "keEdit"){
            supportFragmentManager.commit {
                replace<FragmentEditKonten>(R.id.fragment_container)
                addToBackStack(null)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        saveData()
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    fun saveData(){
        with(sharedPref.edit()) {
            putInt("count", adapter.count)
            for (i in 0 until adapter.count) {
                val item = adapter.getItem(i)
                val title = item.getTitle()
                val desc = item.getDesc()
                val time = item.getTime()
                val uri = item.getUri().toString()

                putString(i.toString() + "_title", title)
                putString(i.toString() + "_desc", desc)
                putString(i.toString() + "_time", time)
                putString(i.toString() + "_uri", uri)
            }
            apply()
        }
    }

    fun loadData(){
        adapter.clearDiary()
        val count = this.sharedPref.getInt("count", 0)
        for (i in 0 until count) {
            val title = this.sharedPref.getString(i.toString()+"_title", "")
            val desc = this.sharedPref.getString(i.toString()+"_desc", "")
            val time = this.sharedPref.getString(i.toString()+"_time", "")
            val uri = this.sharedPref.getString(i.toString()+"_uri", "")

            adapter.addImage(DiaryImage(title!!, desc!!, Uri.parse(uri), time!!))
        }
    }
}