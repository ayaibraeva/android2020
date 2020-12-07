package com.example.mvpapplicaion.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvpapplicaion.R
import com.example.mvpapplicaion.contract.ContractInterface
import com.example.mvpapplicaion.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ContractInterface.View  {
    private  var presenter: MainPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)
    }

    override fun initView() {
        var users = presenter.getUsers()
        counterTextView.text = presenter?.getCounter()
        clickButton.setOnClickListener {
            presenter?.incrementValue()
        }


    }

    override fun updateViewData() {
        counterTextView.text = presenter?.getCounter()


    }
}