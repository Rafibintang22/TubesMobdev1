package com.example.tubes1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.tubes1.databinding.FragmentSidemenuBinding
import kotlin.math.log

class FragmentSideMenu:Fragment() {
    lateinit var binding: FragmentSidemenuBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentSidemenuBinding.inflate(inflater,container,false)
        this.viewModel = (activity as MainActivity).viewModel
        val buttonHome = binding.btnHome
        val buttonAddDiary = binding.btnAddDiary
        val switchMode = binding.switchMode
        switchMode.setOnClickListener {
            val modeNow = switchMode.isChecked
            viewModel.updateMode(modeNow)
        }

        buttonHome.setOnClickListener {
            viewModel.reqCloseDrawer(true)
            pindahkeFragment(FragmentHome())
        }

        buttonAddDiary.setOnClickListener {
            viewModel.reqCloseDrawer(true)
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