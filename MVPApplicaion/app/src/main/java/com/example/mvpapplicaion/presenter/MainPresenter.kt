package com.example.mvpapplicaion.presenter

import com.example.mvpapplicaion.contract.ContractInterface
import com.example.mvpapplicaion.model.MainModel
import com.example.mvpapplicaion.repository.MainRepoImpl
import com.example.mvpapplicaion.repository.MainRepository

class MainPresenter(private val _view: ContractInterface.View): ContractInterface.Presenter {
    private var mainModel: ContractInterface.Model = MainModel()
    private var repository: MainRepository = MainRepoImpl()

    init{
        _view.initView()
    }
    override fun incrementValue() {
        mainModel.incrementCounter()
        _view.updateViewData()
    }

    override fun getCounter(): String {
        return mainModel.getCounter().toString()
    }
//    fun  getUsers(): List<User> {
////        retrofit.call{
////        return response
////    }
    fun getUsers(): List<User>{
        val users = repository.getUser()
        return users
}
}