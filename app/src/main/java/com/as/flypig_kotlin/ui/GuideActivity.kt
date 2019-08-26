package com.`as`.flypig_kotlin.ui

import android.content.Intent
import android.os.Bundle
import android.support.constraint.motion.MotionLayout
import android.support.v7.app.AppCompatActivity
import com.`as`.flypig_kotlin.MainActivity
import com.`as`.flypig_kotlin.R
import kotlinx.android.synthetic.main.guide_layout.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class GuideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onResume() {
        super.onResume()

        val view = layoutInflater.inflate(R.layout.guide_layout, null)


        window.setContentView(view)

//        layoutBinding!!.guideMotion.transitionToEnd()

        view.guide_motion.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
            }

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                doAsync {
                    Thread.sleep(1000)
                    uiThread {
                        val intent = Intent()
                        intent.setClass(this@GuideActivity,MainActivity::class.java)
                        startActivity(intent)
                    }
                }

            }

        })
    }
}

