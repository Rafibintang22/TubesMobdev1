package com.example.tubes1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.DiaryListAdapter
import com.example.tubes1.databinding.FragmentHomeBinding

class FragmentHome : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: DiaryListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentHomeBinding.inflate(inflater,container, false)
        this.viewModel = (activity as MainActivity).viewModel
        this.adapter = (activity as MainActivity).adapter
        val buttonTambah = this.binding.btnTambah
        val gridView = this.binding.lvDiary
        gridView.adapter = this.adapter


        buttonTambah.setOnClickListener {
            viewModel.updatePage("keTambahKonten")
        }

        return this.binding.root
    }

//    fun pindahkeFragment(fragmentBaru : Fragment){
//        val mainActivity = activity as MainActivity
//
//        val fragmentTransaction = mainActivity.supportFragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.fragment_container, fragmentBaru)
//        fragmentTransaction.addToBackStack(null)
//        fragmentTransaction.commit()
//    }
}