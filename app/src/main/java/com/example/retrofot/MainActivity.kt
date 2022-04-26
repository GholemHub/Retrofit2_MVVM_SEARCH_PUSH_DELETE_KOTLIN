package com.example.retrofot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log.d
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofot.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var recyclerMainAdapter: RecyclerMainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        initRecyclerView()
        initViewModel()
        viewModel.getUserList()

        searchUser()

    }

    private fun searchUser() {
        binding.searchBtn.setOnClickListener {
            if(!TextUtils.isEmpty(binding.searchEditText.text.toString())){
                d("TAG", "isEMPTY")
                viewModel.searchUser(binding.searchEditText.text.toString())
            }else{
                d("TAG", "is not EMPTY")
                viewModel.getUserList()
            }
        }
    }


    private fun initRecyclerView(){
        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decoration = DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL)
                addItemDecoration(decoration)

            recyclerMainAdapter = RecyclerMainAdapter(this@MainActivity)
            //recyclerViewAdapter = RecyclerMainAdapter(this@MainActivity)
            adapter = recyclerMainAdapter
        }
    }

    lateinit var viewModel: MainActivityViewModel

    fun initViewModel(){
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getUserListObserverable().observe(this, Observer {
            if(it == null){
                Toast.makeText(this, "No result" , Toast.LENGTH_SHORT).show()
            }else{
                recyclerMainAdapter.userList = it.data.toMutableList()
                recyclerMainAdapter.notifyDataSetChanged()
            }
        })
    }

}