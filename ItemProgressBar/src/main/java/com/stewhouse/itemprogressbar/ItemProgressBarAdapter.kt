package com.stewhouse.itemprogressbar

import android.view.View
import android.view.ViewGroup

open class ItemProgressBarAdapter {
    lateinit var view: ItemProgressBar

    open fun initChildView(container: ViewGroup, position: Int, isProgress: Boolean): View? {
        return null
    }

    open fun initLineView(container: ViewGroup, position: Int, isProgress: Boolean): View? {
        return null
    }

    open fun getItemCount(): Int {
        return 0
    }

    fun notifyDataSetChanged() {
        view.invalidate()
    }
}