package com.`as`.flypig_kotlin.customui

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import com.`as`.flypig_kotlin.R
import com.luliang.shapeutils.DevShapeUtils
import com.luliang.shapeutils.shape.DevShape

/**
 *-----------------------------
 * Created by zqf on 2019/8/22.
 *---------------------------
 */
class OvaLTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : TextView(context, attrs, defStyleAttr) {

    // 默认颜色
    var thecolor : Int= R.color.salmon

    init {
        DevShapeUtils.shape(DevShape.OVAL)
            .radius(50F)
            .solid(this.thecolor)
            .line(1,R.color.white)
            .into(this)
    }





}