package com.example.tubes1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.tubes1.databinding.FragmentSidemenuBinding

class FragmentSideMenu:Fragment() {
    lateinit var binding: FragmentSidemenuBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentSidemenuBinding.inflate(inflater,container,false)

        val buttonHome = binding.btnHome
        val buttonAddDiary = binding.btnAddDiary


        buttonHome.setOnClickListener {
            pindahkeFragment(FragmentHome())
        }

        buttonAddDiary.setOnClickListener {
            pindahkeFragment(FragmentTambahKonten())
        }

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