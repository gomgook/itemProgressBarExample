package com.stewhouse.itemprogressbar.utility

import android.content.Context
import android.util.TypedValue

class UIUtil {
    companion object {
        fun dpToPx(context: Context, dp: Float): Float {
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.resources.displayMetrics)
        }
    }
}