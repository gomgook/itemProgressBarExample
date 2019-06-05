package com.stewhouse.itemprogressbarexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data: ArrayList<String> = ArrayList()

        data.add("1")
        data.add("2")
        data.add("3")

        val adapter = CustomItemProgressBarAdapter(this)

        adapter.data = data
        itemProgressBar.adapter = adapter
        itemProgressBar.currentProgress = 3
    }
}
