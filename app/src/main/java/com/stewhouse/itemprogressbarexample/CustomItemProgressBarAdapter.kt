package com.stewhouse.itemprogressbarexample

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.ViewGroup
import com.stewhouse.itemprogressbar.ItemProgressBarAdapter
import kotlinx.android.synthetic.main.layout_progress_item.view.*
import kotlinx.android.synthetic.main.layout_progress_item_line_default.view.*

class CustomItemProgressBarAdapter(private val context: Context) : ItemProgressBarAdapter() {
    var data: List<String> = ArrayList()

    override fun getItemCount(): Int {
        return data.size
    }

    override fun initChildView(container: ViewGroup, position: Int, isProgress: Boolean): View? {
        val view = View.inflate(context, R.layout.layout_progress_item, container)

        view.text.text = data[position]

        if (isProgress) {
            view.layout.background = ContextCompat.getDrawable(context, R.drawable.ic_item_bg_progress)
        }

        return view
    }

    override fun initLineView(container: ViewGroup, position: Int, isProgress: Boolean): View? {
        val view = View.inflate(context, R.layout.layout_progress_item_line_default, container)

        if (isProgress) {
            view.line.setBackgroundColor(ContextCompat.getColor(context, R.color.black))
        }

        return view
    }
}