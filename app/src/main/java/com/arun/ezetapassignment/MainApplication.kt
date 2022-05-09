package com.arun.ezetapassignment

import androidx.multidex.MultiDexApplication
import com.arun.ezetapassignment.NetworkModule.networkModule
import com.arun.ezetapassignment.NetworkModule.repositories
import com.arun.ezetapassignment.NetworkModule.viewModels
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext


/**
// Created by Arun Singh Rawat on 09-05-2022.
 **/

class MainApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(networkModule, viewModels, repositories)
        }
    }
}