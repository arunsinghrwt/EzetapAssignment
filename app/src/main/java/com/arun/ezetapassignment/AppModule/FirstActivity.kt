package com.arun.ezetapassignment.AppModule

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.arun.ezetapassignment.NetworkModule.Di.ResultObserver
import com.arun.ezetapassignment.NetworkModule.MainViewModel
import com.arun.ezetapassignment.NetworkModule.ResponseModel
import com.arun.ezetapassignment.databinding.ActivityMainBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl
import com.google.gson.GsonBuilder
import org.koin.android.ext.android.inject

class FirstActivity : AppCompatActivity(), View.OnClickListener {
    private val mViewModel: MainViewModel by inject()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        mViewModel.callGetDetails()
        mViewModel.detailsLiveData.observe(this) {
            when (it) {
                is ResultObserver.Loading ->binding.progressCircular.show()
                is ResultObserver.Success -> {
                    binding.progressCircular.gone()
                    if (it.data != null){ setData(it.data) }
                }
                is ResultObserver.Error -> {
                    binding.progressCircular.gone()
                    it.exception
                    Toast.makeText(this,it.exception.toString(),Toast.LENGTH_LONG).show()
                }
            }
        }

        binding.next.setOnClickListener(this)

    }

    private fun setData(data: ResponseModel) {
        binding.headerTitle.text = data.heading
        if (data.uiDataList != null){
            mViewModel.setCustomUIList(data.uiDataList!!)
        }
        loadImageNetwork(data.logo)
    }

    private fun loadImageNetwork(url: String?) {
        Glide.with(this).asBitmap()
            .load(GlideUrl(url))
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(true)
            .into(binding.logo)
    }
    override fun onClick(p0: View?) {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}