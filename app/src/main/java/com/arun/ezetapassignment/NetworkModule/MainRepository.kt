package com.arun.ezetapassignment.NetworkModule

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.arun.ezetapassignment.NetworkModule.Di.ResultObserver
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
// Created by Arun Singh Rawat on 09-05-2022.



 **/

class MainRepository(private val apisList: ApiList) {

    val detailsLiveData = MutableLiveData<ResultObserver<ResponseModel>>()
    fun callDetails() {
        Log.e("callDetails","-->>>")
        detailsLiveData.postValue(ResultObserver.Loading)
        apisList.getData().enqueue(object : Callback<ResponseModel> {
            override fun onResponse(
                call: Call<ResponseModel>,
                response: Response<ResponseModel>
            ) {
                Log.e("response","-->>>")
                if (response.isSuccessful) {
                    detailsLiveData.postValue(ResultObserver.Success(response.body()!!))
                } else {
                    detailsLiveData.postValue(ResultObserver.Error(Exception("no value")))
                }
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                Log.e("onFailure","-->>>")
                detailsLiveData.postValue(ResultObserver.Error(Exception(t)))
            }
        })
    }

    val customUiListLiveData = MutableLiveData<ArrayList<DataList>>()
    fun setCustomUIList(uiList : ArrayList<DataList>) {
        customUiListLiveData.postValue(uiList)
    }








}