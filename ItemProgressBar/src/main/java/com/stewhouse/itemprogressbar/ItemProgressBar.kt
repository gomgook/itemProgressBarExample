package com.stewhouse.itemprogressbar

import android.content.Context
import android.os.Build.VERSION_CODES.LOLLIPOP
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.stewhouse.itemprogressbar.utility.UIUtil
import kotlinx.android.synthetic.main.layout_progress_bar.view.*
import java.util.*

class ItemProgressBar : RelativeLayout {
    var listener: ItemProgressBarListener? = null
        set(value) {
            if (value == null) throw Throwable("ItemProgressBarLister is null.")

            field = value
        }

    // position starts from 1.
    private var currentPosition = Int.MIN_VALUE
        set(value) {
            if (value < 1) throw Throwable("Current position should start from 1.")

            field = value
            setProgress(field)
        }
    private var maxPosition = Int.MIN_VALUE
        set(value) {
            if (value < 1) throw Throwable("Max position should be started from 1.")

            field = value
        }

    init {
        View.inflate(context, R.layout.layout_progress_bar, this)
    }

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @RequiresApi(LOLLIPOP)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    )

    /**
     * Set ProgressBar UI.
     */
    public fun constructProgressBar(data: List<Any>, listener: ItemProgressBarListener?) {
        if (itemLayout.childCount > 0) itemLayout.removeAllViews()

        maxPosition = data.size
        this.listener = listener

        when {
            data.isEmpty() -> return
            data.size == 1 -> initSingleProgressItem()
            else -> initProgressItems(data)
        }
        initLastProgressItem()
    }

    // ================================================================================================================
    // Items initiation functions
    // ================================================================================================================

    private fun initSingleProgressItem() {
        itemLayout.visibility = GONE
        val layoutParams = lastItemView.layoutParams as LayoutParams

        layoutParams.addRule(ALIGN_PARENT_RIGHT, 0)
        layoutParams.addRule(ALIGN_PARENT_LEFT, TRUE)
        layoutParams.leftMargin = UIUtil.dpToPx(context, 12F).toInt()
    }

    private fun initProgressItems(data: List<Any>) {
        if (maxPosition == 1) {
            itemLayout.weightSum = 1F
            lastItemView.visibility = GONE
            setSingleItem(data[0])
        } else {
            itemLayout.weightSum = (maxPosition - 1).toFloat()
            lastItemView.visibility = View.VISIBLE

            val layoutParams: RelativeLayout.LayoutParams = itemLayout.layoutParams as LayoutParams

            layoutParams.addRule(LEFT_OF, lastItemView.id)
            setItems(data)

            // TODO: lottie animation setting and text setting
        }
    }

    private fun initLastProgressItem() {
        // TODO: init last progress lottie animation
    }

    private fun setSingleItem(data: Any) {
        val childView = getProgressItemView(data)

        // TODO: set lottie animation
    }

    private fun setProgress(position: Int) {

    }

    private fun setItems(data: List<Any>) {

    }

    private fun getProgressItemView(data: Any) {

    }
}