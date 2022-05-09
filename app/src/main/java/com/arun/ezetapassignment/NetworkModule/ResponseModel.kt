package com.arun.ezetapassignment.NetworkModule

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
// Created by Arun Singh Rawat on 09-05-2022.
 **/

class ResponseModel {
  @SerializedName("logo-url")
  @Expose
  var logo: String? = null

  @SerializedName("heading-text")
  @Expose
  var heading : String? = null

  @SerializedName("uidata")
  @Expose
  var uiDataList : ArrayList<DataList>? = null


}

class DataList {
  @SerializedName("uitype")
  @Expose
  var uiType: String? = null

  @SerializedName("value")
  @Expose
  var value: String? = null

  @SerializedName("key")
  @Expose
  var key : String? = null

  @SerializedName("hint")
  @Expose
  var hint : String? = null
}