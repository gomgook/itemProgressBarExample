package com.stewhouse.itemprogressbarexample

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.stewhouse.itemprogressbar.ItemProgressBarAdapter
import kotlinx.android.synthetic.main.layout_progress_item.view.*

class CustomItemProgressBarAdapter(private val context: Context) : ItemProgressBarAdapter() {
    var data: List<String> = ArrayList()

    override fun getItemCount(): Int {
        return data.size
    }

    override fun initChildView(container: ViewGroup, position: Int): View? {
        val view = View.inflate(context, R.layout.layout_progress_item, container)

        view.text.text = data[position]

        return view
    }

    override fun initLineView(container: ViewGroup, position: Int): View? {
        return View.inflate(context, R.layout.layout_progress_item_line, container)
    }
}