package com.stewhouse.itemprogressbarexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import com.stewhouse.itemprogressbar.ItemProgressBarAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data: ArrayList<String> = ArrayList()

        data.add("40")
        data.add("10")
        data.add("30")
        data.add("20")
        data.add("50")

        val adapter = CustomItemProgressBarAdapter(this)

        adapter.data = data
        itemProgressBar.adapter = adapter
    }
}
