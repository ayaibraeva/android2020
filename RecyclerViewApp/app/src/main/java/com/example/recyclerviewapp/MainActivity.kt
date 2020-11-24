package com.example.recyclerviewapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var  sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE)

        val userJson = sharedPreferences.getString("user", "")
        if(userJson!!.isNotEmpty()){
            val user = Gson().fromJson(userJson, User::class.java)
        }


//        val user = intent.getParcelableExtra<User>("user")
        val users = ArrayList<User>()
        for(i in 1..9) {
            users.add(User("Name" + i,"", "employee", 20+i ))
        }
        val userListAdapter = UserListAdapter(users, this )
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false )
        recyclerview.layoutManager = layoutManager
        recyclerview.adapter = userListAdapter
    }
}