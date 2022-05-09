package com.arun.ezetapassignment.NetworkModule

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


/**
// Created by Arun Singh Rawat on 09-05-2022.
 **/

var networkModule = module {
  single { getLogInterceptor() }
  single { returnRetrofit(get()) }
  single { getApi(get()) }
}

val repositories = module {
  single { MainRepository(get()) }

}
val viewModels = module {
  viewModel { MainViewModel(get()) }

}