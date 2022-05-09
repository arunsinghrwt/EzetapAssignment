package com.arun.ezetapassignment.NetworkModule

import retrofit2.Call

import retrofit2.http.Headers
import retrofit2.http.POST


/**
// Created by Arun Singh Rawat on 09-05-2022.
 **/

interface ApiList {

    companion object {
        const val BASE_PATH = "https://demo.ezetap.com"
    }

    @Headers("Content-Type: application/json")
    @POST("/mobileapps/android_assignment.json")
    fun getData(): Call<ResponseModel>

}