package com.arun.ezetapassignment.NetworkModule

import android.text.Editable
import androidx.lifecycle.ViewModel


/**
// Created by Arun Singh Rawat on 09-05-2022.



 **/

class MainViewModel (private val mainRepository: MainRepository) : ViewModel(){

    //getDetails
    val detailsLiveData = mainRepository.detailsLiveData
    fun callGetDetails() {mainRepository.callDetails()}


    //Custom Ui Details
    val customUiListLiveData = mainRepository.customUiListLiveData
    fun setCustomUIList(uiList: ArrayList<DataList>) {
        mainRepository.setCustomUIList(uiList)
    }

}