package com.example.tubes1

import android.os.Bundle
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
        val update = this.binding.buttonUpdate
        update.setOnClickListener{
            pindahKeFragment(FragmentKontenDiary())
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