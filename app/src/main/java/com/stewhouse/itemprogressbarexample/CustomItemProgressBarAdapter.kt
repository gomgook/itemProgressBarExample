package com.stewhouse.itemprogressbarexample

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.stewhouse.itemprogressbar.ItemProgressBarAdapter

class CustomItemProgressBarAdapter(private val context: Context) : ItemProgressBarAdapter() {
    var data: List<String> = ArrayList()

    override fun getItemCount(): Int {
        return data.size
    }

    override fun initChildView(container: ViewGroup): View? {
        return View.inflate(context, R.layout.layout_progress_item, container)
    }

    override fun initLineView(container: ViewGroup): View? {
        return View.inflate(context, R.layout.layout_progress_item_line, container)
    }
}