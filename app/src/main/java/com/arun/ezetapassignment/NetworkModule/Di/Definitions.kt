package com.arun.ezetapassignment.NetworkModule

import androidx.multidex.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
// Created by Arun Singh Rawat on 09-05-2022.
 **/

/**
 * definitions for dependency injection for all selected classes
 */
  fun getLogInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().apply {
      if (BuildConfig.DEBUG) {
        setLevel(HttpLoggingInterceptor.Level.BODY)
      } else {
        setLevel(HttpLoggingInterceptor.Level.NONE)
      }
    }

  }

  fun returnRetrofit(interceptor: HttpLoggingInterceptor): Retrofit {
    val client = OkHttpClient.Builder()
      .addInterceptor(interceptor)
      .build()

    return Retrofit.Builder().baseUrl(ApiList.BASE_PATH)
      .addConverterFactory(GsonConverterFactory.create())
      .client(client).build()
  }

  fun getApi(retrofit: Retrofit): ApiList {
    return retrofit.create(ApiList::class.java)
  }
