package com.example.mvpapplicaion.model

import com.example.mvpapplicaion.contract.ContractInterface

class MainModel: ContractInterface.Model {
    private var mCounter= 0
    override fun getCounter(): Int {
        return mCounter
    }

    override fun incrementCounter() {
        mCounter++
    }
}