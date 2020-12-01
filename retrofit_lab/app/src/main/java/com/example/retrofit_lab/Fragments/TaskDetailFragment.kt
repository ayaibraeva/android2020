package com.example.retrofit_lab.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.retrofit_lab.MainActivity

import com.example.retrofit_lab.Model.Todos
import com.example.retrofit_lab.R
import kotlinx.android.synthetic.main.task_detail_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TaskDetailFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.task_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val taskId = arguments?.getInt("taskId")!!
        val userId = arguments?.getInt("userId")!!



            MainActivity.apiService.getTaskById(taskId).enqueue(object : Callback<Todos> {
                override fun onFailure(call: Call<Todos>, t: Throwable) {
                    Log.e("Error", t.message.toString())
                }

                override fun onResponse(call: Call<Todos>, response: Response<Todos>) {
                    Log.e("Response: ", response.body()!!.toString())

                    val list = response.body()!!
                    task_detail_title.text = list.title
                    checkbox_detail.isChecked = list.completed
                    userID.text = list.userId.toString()
                    taskID.text = list.id.toString()


                }
            })

        }
    }




