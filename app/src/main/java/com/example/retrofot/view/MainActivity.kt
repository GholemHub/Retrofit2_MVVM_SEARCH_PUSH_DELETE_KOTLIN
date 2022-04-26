package com.example.retrofot.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log.d
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofot.adapters.RecyclerMainAdapter
import com.example.retrofot.databinding.ActivityMainBinding
import com.example.retrofot.model.MainRepository
import com.example.retrofot.model.MainRepository.Companion.activity
import com.example.retrofot.model.MainRepository.Companion.recyclerMainAdapter
import com.example.retrofot.model.MainRepository.Companion.viewModel
import com.example.retrofot.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    lateinit var bindingMain: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingMain = ActivityMainBinding.inflate(layoutInflater)


        MainRepository.activity = this
        d("TAG", "activity = this1: ")

        setContentView(bindingMain.root)
        initViewModel()

    }

    fun initViewModel(){
        viewModel = ViewModelProvider(MainRepository.activity).get(MainActivityViewModel::class.java)
        viewModel.getUserListObserverable().observe(MainRepository.activity, Observer {
            if(it == null){
                Toast.makeText(MainRepository.activity, "No result" , Toast.LENGTH_SHORT).show()
            }else{
                recyclerMainAdapter.userList = it.data.toMutableList()
                recyclerMainAdapter.notifyDataSetChanged()
            }
        })
    }







}