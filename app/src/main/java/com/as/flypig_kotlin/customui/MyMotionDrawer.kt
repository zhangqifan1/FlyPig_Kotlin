package com.`as`.flypig_kotlin.customui

import android.content.Context
import android.support.constraint.motion.MotionLayout
import android.support.v4.widget.DrawerLayout
import android.util.AttributeSet
import android.view.View

/**
 *-----------------------------
 * Created by zqf on 2019/8/21.
 *---------------------------
 */
class MyMotionDrawer @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MotionLayout(context, attrs, defStyleAttr),DrawerLayout.DrawerListener{
    override fun onDrawerStateChanged(p0: Int) {

    }

    override fun onDrawerSlide(p0: View, p1: Float) {
        progress=p1
    }

    override fun onDrawerClosed(p0: View) {

    }

    override fun onDrawerOpened(p0: View) {
    }


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        (parent as DrawerLayout)?.addDrawerListener(this)
    }
}