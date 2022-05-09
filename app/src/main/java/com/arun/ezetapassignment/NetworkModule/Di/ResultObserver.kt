package com.arun.ezetapassignment.NetworkModule.Di


/**
// Created by Arun Singh Rawat on 09-05-2022.
 **/

sealed class ResultObserver<out R> {
  data class Success<out T>(val data: T) : ResultObserver<T>()
  object Loading : ResultObserver<Nothing>()
  data class Error(val exception: Exception) : ResultObserver<Nothing>()
}
