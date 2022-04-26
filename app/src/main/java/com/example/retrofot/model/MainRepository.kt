package com.example.retrofot.model

import com.example.retrofot.adapters.RecyclerMainAdapter
import com.example.retrofot.view.MainActivity
import com.example.retrofot.viewmodel.MainActivityViewModel


class MainRepository {

    companion object{

        lateinit var activity: MainActivity
        @JvmStatic
        lateinit var repository: MainRepository
        lateinit var viewModel: MainActivityViewModel
        lateinit var recyclerMainAdapter: RecyclerMainAdapter
    }

    constructor(){
        activity = MainActivity()
    }



}