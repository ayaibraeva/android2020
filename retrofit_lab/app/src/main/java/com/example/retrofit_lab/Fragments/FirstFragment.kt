package com.example.retrofit_lab.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit_lab.Adapter.MyAdapter
import com.example.retrofit_lab.MainActivity
import com.example.retrofit_lab.Model.Todos
import com.example.retrofit_lab.R
import kotlinx.android.synthetic.main.first_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FirstFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.first_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewToDo.adapter =
            MyAdapter(view.context)
        recyclerViewToDo.layoutManager = LinearLayoutManager(view.context)
        MainActivity.apiService.getTasks().enqueue(object : Callback<MutableList<Todos>> {
            override fun onFailure(call: Call<MutableList<Todos>>, t: Throwable) {
                Log.e("Error", t.message.toString())
            }
            override fun onResponse(call: Call<MutableList<Todos>>, response: Response<MutableList<Todos>>) {
                Log.e("Response: ", response.body()!!.size.toString())
                MainActivity.tasks = response.body()!!
                (recyclerViewToDo.adapter as MyAdapter).notifyDataSetChanged()
            }
        })
    }
}