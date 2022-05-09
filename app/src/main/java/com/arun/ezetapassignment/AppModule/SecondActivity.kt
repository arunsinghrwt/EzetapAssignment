package com.arun.ezetapassignment.AppModule

import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.arun.ezetapassignment.NetworkModule.DataList
import com.arun.ezetapassignment.NetworkModule.MainViewModel
import com.arun.ezetapassignment.databinding.ActivitySecondBinding
import org.koin.android.ext.android.inject


/**
// Created by Arun Singh Rawat on 09-05-2022.
 **/

class SecondActivity : AppCompatActivity() {

    private val mViewModel: MainViewModel by inject()
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        if (mViewModel.customUiListLiveData.value != null){
              val  mList : ArrayList<DataList> = mViewModel.customUiListLiveData.value!!
               for (list : DataList in mList) {
                   Log.e("loop","-->>>"+list.uiType)
                   when {
                       list.uiType.equals("label") -> {
                            addTextView(list)
                       }
                       list.uiType.equals("edittext") -> {
                           addEditTextView(list)
                       }
                       list.uiType.equals("button") -> {
                           addButtonView(list)
                       }
                   }
               }
        }

    }

    private fun addButtonView(list: DataList) {
        val button = Button(this)
        button.text = list.value
        button.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                setMargins(0,60,0,0)
        }

        button.setPadding(0, 5, 0, 5)
        binding.mainLayout.addView(button)
    }

    private fun addEditTextView(list: DataList) {
        val editText = EditText(this)
        editText.hint = list.hint
        editText.setText(list.value)
        editText.tag = list.key
        editText.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT).apply {
            setMargins(0,0,0,20)
        }
        editText.setPadding(20, 20, 20, 20)

        binding.mainLayout.addView(editText)
    }

    private fun addTextView(list: DataList) {
        val textView = TextView(this)
        textView.text = list.value
        textView.tag = list.key
        textView.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        textView.setPadding(20, 5, 20, 5)
        binding.mainLayout.addView(textView)
    }


}