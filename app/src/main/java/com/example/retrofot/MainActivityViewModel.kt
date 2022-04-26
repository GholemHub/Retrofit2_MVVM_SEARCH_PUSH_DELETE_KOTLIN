package com.example.retrofot

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofot.data.UserList
import com.example.retrofot.retrofit.RetroInstance
import com.example.retrofot.retrofit.RetroServiceInterface
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Call



class MainActivityViewModel: ViewModel() {

   var recyclerListData: MutableLiveData<UserList>

    init{
        recyclerListData = MutableLiveData()
    }

    fun getUserListObserverable():  MutableLiveData<UserList>{
        return recyclerListData
    }

    fun getUserList(){
        val retroInstance = RetroInstance.getRetrofitInstance().create(RetroServiceInterface::class.java)
        val call = retroInstance.getUserList()
        call.enqueue(object : Callback<UserList>{///21.33
            override fun onFailure(call: Call<UserList>, t: Throwable) {
                recyclerListData.postValue(null)
            }

            override fun onResponse(call: Call<UserList>, response: Response<UserList>) {
                if(response.isSuccessful) {
                    recyclerListData.postValue(response.body())
                } else {
                    recyclerListData.postValue(null)
                }
            }
        })
    }

    fun searchUser(searchText: String){

        val retroInstance = RetroInstance.getRetrofitInstance().create(RetroServiceInterface::class.java)
        val call = retroInstance.searchUsers(searchText)
        call.enqueue(object : Callback<UserList>{///21.33
        override fun onFailure(call: Call<UserList>, t: Throwable) {
            recyclerListData.postValue(null)
        }

            override fun onResponse(call: Call<UserList>, response: Response<UserList>) {
                if(response.isSuccessful) {
                    recyclerListData.postValue(response.body())
                } else {
                    recyclerListData.postValue(null)
                }
            }
        })
    }
}
