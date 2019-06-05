package com.stewhouse.itemprogressbar

import android.content.Context
import android.os.Build
import android.os.Build.VERSION_CODES.LOLLIPOP
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.layout_progress_bar.view.*

class ItemProgressBar : RelativeLayout {
    var adapter: ItemProgressBarAdapter? = null
        set(value) {
            field = value

            field?.view = this
            field?.notifyDataSetChanged()
        }

    init {
        View.inflate(context, R.layout.layout_progress_bar, this)

        if (itemLayout.childCount > 0) itemLayout.removeAllViews()
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

    override fun invalidate() {
        constructItems()

        super.invalidate()
    }

    private fun constructItems() {
        when (adapter?.getItemCount()) {
            0 -> return
            1 -> initSingleItem()
            else -> initMultipleItems()
        }
    }

    private fun initSingleItem() {
        itemLayout.visibility = View.GONE

        val layoutParams: LayoutParams = lastItemView.layoutParams as LayoutParams

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) layoutParams.addRule(ALIGN_PARENT_END, 0)
        layoutParams.addRule(ALIGN_PARENT_RIGHT, 0)
        layoutParams.addRule(ALIGN_PARENT_LEFT, TRUE)

        adapter?.initChildView(lastItemView, 0)
    }

    private fun initMultipleItems() {
        adapter?.let {
            itemLayout.weightSum = (it.getItemCount() - 1).toFloat()

            val layoutParams: LayoutParams = itemLayout.layoutParams as LayoutParams
            layoutParams.addRule(LEFT_OF, lastItemView.id)

            setChildViews()
            setLastView()

            itemLayout.visibility = View.VISIBLE
        }
    }

    private fun setChildViews() {
        adapter?.let {
            for (i in 0 until it.getItemCount() - 1) {
                val parentView = LinearLayout(context)
                val parentLayoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1F)

                parentView.layoutParams = parentLayoutParams
                parentView.orientation = LinearLayout.HORIZONTAL

                it.initChildView(parentView, i)
                it.initLineView(parentView, i)

                itemLayout.addView(parentView)
            }
        }
    }

    private fun setLastView() {
        adapter?.let {
            it.initChildView(lastItemView, it.getItemCount() - 1)
        }
    }
}