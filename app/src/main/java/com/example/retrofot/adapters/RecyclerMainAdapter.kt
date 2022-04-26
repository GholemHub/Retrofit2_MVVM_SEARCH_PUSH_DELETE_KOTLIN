package com.example.retrofot.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofot.R
import com.example.retrofot.data.User
import com.example.retrofot.view.MainActivity


class RecyclerMainAdapter(val clickListener: MainActivity): RecyclerView.Adapter<RecyclerMainAdapter.mViewHolder>() {

    var userList = mutableListOf<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row_list, parent, false)
        return mViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: mViewHolder, position: Int) {
        holder.bind(userList[position])
        holder.itemView.setOnClickListener {

        }
    }

    class mViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val textViewName: TextView = view.findViewById(R.id.textViewName)
        val textViewEmail: TextView = view.findViewById(R.id.textViewEmail)
        val textViewStats: TextView = view.findViewById(R.id.textViewStats)

        fun bind(data : User) {
            textViewName.text = data.name
            textViewEmail.text = data.email
            textViewStats.text = data.status
        }
    }

    interface OnItemClickListener {
        fun onItemEditCLick(user : User)
    }




}