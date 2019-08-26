package com.`as`.flypig_kotlin.customui

import android.content.Context
import android.support.constraint.motion.MotionLayout
import android.support.design.widget.AppBarLayout
import android.util.AttributeSet

/**
 *-----------------------------
 * Created by zqf on 2019/8/22.
 *---------------------------
 */
class MyMotionBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MotionLayout(context, attrs, defStyleAttr),AppBarLayout.OnOffsetChangedListener {

    /**
     * 以我目前的境界来看   这个类主要是 把MotionLaayout 和 AppbarLayout 关联起来
     * 给他加了一个 addOnOffsetChangedListener
     */
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        (parent as? AppBarLayout)?.addOnOffsetChangedListener(this)
    }


    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        progress = -verticalOffset / appBarLayout?.totalScrollRange?.toFloat()!!
    }


}