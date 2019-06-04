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

        data.add("40")
        data.add("10")
        data.add("20")
        data.add("30")
        data.add("50")
        data.add("60")
        data.add("80")

        val listener = object : ItemProgressBarListener {
            override fun onProgressFinished() {

            }
        }

        itemProgressBar.initProgressBar(data, listener)
    }
}
