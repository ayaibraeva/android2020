package com.example.mvpapplicaion.contract

interface ContractInterface {
    interface View{
        fun initView()
        fun updateViewData()
    }
    interface Presenter{
        fun incrementValue()
        fun getCounter(): String
    }
    interface Model{
        fun getCounter(): Int
        fun incrementCounter()
    }
}