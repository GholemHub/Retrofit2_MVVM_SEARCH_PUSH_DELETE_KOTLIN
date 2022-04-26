package com.example.retrofot.view

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofot.R
import com.example.retrofot.adapters.RecyclerMainAdapter
import com.example.retrofot.databinding.FragmentMainBinding
import com.example.retrofot.model.MainRepository
import com.example.retrofot.model.MainRepository.Companion.recyclerMainAdapter
import com.example.retrofot.model.MainRepository.Companion.repository
import com.example.retrofot.model.MainRepository.Companion.viewModel
import com.example.retrofot.viewmodel.MainActivityViewModel

class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_main, container, false)
        d("TAG", "activity = this: ")

        repository = MainRepository()


        //MainRepository.activity = MainActivity()

        initRecyclerView()

        //MainActivity.initViewModel()


        searchUser()

        return binding.root
    }


    fun initRecyclerView(){
        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(activity)
            //d("TAG","MainRepository.activity: ${MainRepository.activity}" )
            val decoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)

            recyclerMainAdapter = RecyclerMainAdapter(MainRepository.activity)
            //recyclerViewAdapter = RecyclerMainAdapter(this@MainActivity)
            adapter = recyclerMainAdapter
        }
    }

    private fun searchUser() {
        binding.searchBtn.setOnClickListener {
            if(!TextUtils.isEmpty(binding.searchEditText.text.toString())){
                Log.d("TAG", "isEMPTY")
                viewModel.searchUser(binding.searchEditText.text.toString())
            }else{
                Log.d("TAG", "is not EMPTY")
                viewModel.getUserList()
            }
        }
    }


}