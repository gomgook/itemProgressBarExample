package com.stewhouse.itemprogressbarexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.stewhouse.itemprogressbar.ItemProgressBarListener
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data: ArrayList<Any> = ArrayList()
        val stringData = "12"
        data.add(stringData)

        val listener = object : ItemProgressBarListener {
            override fun onProgressFinished() {

            }
        }

        itemProgressBar.initProgressBar(data, listener)
    }
}
