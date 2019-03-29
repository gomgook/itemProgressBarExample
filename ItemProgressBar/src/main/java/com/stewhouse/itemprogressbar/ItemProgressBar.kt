package com.stewhouse.itemprogressbar

import android.content.Context
import android.os.Build
import android.os.Build.VERSION_CODES.LOLLIPOP
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.stewhouse.itemprogressbar.utility.UIUtil
import kotlinx.android.synthetic.main.layout_progress_bar.view.*

class ItemProgressBar : RelativeLayout {
    var listener: ItemProgressBarListener? = null
        set(value) {
            if (value == null) throw Throwable("ItemProgressBarListener is null.")

            field = value
        }

    // position starts with 1.
    private var currentPosition = Int.MIN_VALUE
        set(value) {
            if (value < 1) throw Throwable("Current position should start with 1.")

            field = value
        }
    private var maxPosition = Int.MIN_VALUE
        set(value) {
            if (value < 1) throw Throwable("Max position should start with 1.")

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
    public fun initProgressBar(data: List<Any>, listener: ItemProgressBarListener?) {
        if (itemLayout.childCount > 0) itemLayout.removeAllViews()

        maxPosition = data.size
        this.listener = listener

        when {
            data.isEmpty() -> return
            data.size == 1 -> initSingleItem()
            else -> initItems()
        }

        initLastItem()
    }

    private fun initSingleItem() {
        itemLayout.visibility = View.GONE

        val layoutParams: RelativeLayout.LayoutParams = lastItemView.layoutParams as LayoutParams

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) layoutParams.addRule(ALIGN_PARENT_END, 0)
        layoutParams.addRule(ALIGN_PARENT_RIGHT, 0)
        layoutParams.addRule(ALIGN_PARENT_LEFT, TRUE)
        layoutParams.leftMargin = UIUtil.dpToPx(context, 12f).toInt()
    }

    private fun initItems() {
        // TODO: add progress items
    }

    private fun initLastItem() {

    }
}