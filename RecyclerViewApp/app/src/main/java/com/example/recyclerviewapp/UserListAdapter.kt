package com.example.recyclerviewapp

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class UserListAdapter(val users: ArrayList<User>, val context: Context):
    RecyclerView.Adapter<UserListAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false)

        return MyViewHolder(view, context)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = users.get(position)
        holder.nameText.text = user.name
        holder.positionText.text = user.position
    }
    class MyViewHolder (view: View, context: Context): RecyclerView.ViewHolder(view){
        var nameText: TextView = view.findViewById(R.id.name)
        var positionText:  TextView = view.findViewById(R.id.position)
        var imageView: ImageView = view.findViewById(R.id.image)
        var random = java.util.Random()
        init {
            imageView.layoutParams.height= getRandomIntInRange(250, 250)
            view.setOnClickListener { Toast.makeText(context, nameText.text, Toast.LENGTH_SHORT).show() }
        }
        private fun getRandomIntInRange (max: Int, min: Int): Int {
            return random.nextInt(max - min + min ) + min
        }
    }
}