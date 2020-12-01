package com.example.retrofit_lab.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_lab.MainActivity
import com.example.retrofit_lab.Model.Todos
import com.example.retrofit_lab.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyAdapter(val context: Context): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_fragment, parent,false)
        instance = this
        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return MainActivity.tasks.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val task = MainActivity.tasks[position]
        holder.titleText.text = task.title
        holder.completedCheckBox.isChecked = task.completed

        holder.itemView.setOnClickListener {
            val bundle = bundleOf("taskId" to task.id, "userId" to task.userId)
            it.findNavController().navigate(R.id.action_firstFragment_to_taskDetailFragment, bundle)
        }

        val checkBox = holder.itemView.findViewById<CheckBox>(R.id.checkbox_item)
        checkBox.setOnClickListener {
            MainActivity.apiService.updateTask(
                task.id,
                checkBox.isChecked
            ).enqueue(object : Callback<Todos> {
                override fun onFailure(call: Call<Todos>, t: Throwable) {
                    Log.e("Error", t.message.toString())
                }

                override fun onResponse(call: Call<Todos>, response: Response<Todos>) {
                    Log.e("Response: ", response.body()!!.toString())
                }
            })
        }

    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleText: TextView = itemView.findViewById(R.id.titleTextView)
        var completedCheckBox: CheckBox = itemView.findViewById(R.id.checkbox_item)
    }


    companion object {
        lateinit var instance: MyAdapter
    }
}