package com.stewhouse.itemprogressbarexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import com.stewhouse.itemprogressbar.ItemProgressBar
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
        data.add("4")
        data.add("5")
        data.add("6")
        data.add("7")

        val adapter = CustomItemProgressBarAdapter(this)

        adapter.data = data
        itemProgressBar.adapter = adapter
        itemProgressBar.currentProgress = 1
        itemProgressBar.progressPrevListener = object : ItemProgressBar.ProgressListener {
            override fun onProgress(currentView: View, nextView: View) {
                currentView.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.colorAccent))
                nextView.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.colorPrimary))
            }
        }

        nextBtn.setOnClickListener {
            itemProgressBar.progressNext()
        }

        prevBtn.setOnClickListener {
            itemProgressBar.progressPrev()
        }
    }
}
