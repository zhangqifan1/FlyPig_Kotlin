package com.`as`.flypig_kotlin.ui.fragment


import android.support.v4.app.Fragment
import android.support.v4.widget.NestedScrollView
import com.`as`.base.ui.fragment.BaseFragment
import com.`as`.base.utilcode.util.ToastUtils
import com.`as`.flypig_kotlin.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_btm1.*


/**
 * A simple [Fragment] subclass.
 *
 */
class Btm1Fragment : BaseFragment() {


    var fab_h = 0
    var bnve_height = 0
    var isShow = true

    override fun setLayoutId(): Int {
        return R.layout.fragment_btm1
    }


    override fun initView() {

        //如果是 直接setTranstionY  需要用到这俩个
//        activity!!.fab.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
//            override fun onGlobalLayout() {
//                activity!!.fab.viewTreeObserver.removeOnGlobalLayoutListener(this)
//                fab_h = activity!!.fab.bottom + activity!!.fab.height
//            }
//        })
//
//        activity!!.bnve.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
//            override fun onGlobalLayout() {
//                activity!!.bnve.viewTreeObserver.removeOnGlobalLayoutListener(this)
//                bnve_height = activity!!.bnve.height
//            }
//        })

        nest_croll_view.setOnScrollChangeListener(object : NestedScrollView.OnScrollChangeListener {
            override fun onScrollChange(
                p0: NestedScrollView?,
                scrollX: Int,
                scrollY: Int,
                oldscrollX: Int,
                oldscrollY: Int
            ) {
                if (scrollY - oldscrollY > 0 && isShow) {
                    isShow = false

                    activity!!.fab.animate()
                        .setDuration(1000)
                        .translationY(300F)
                        .withLayer()
                        .start()

                    activity!!.bnve.animate()
                        .setDuration(1000)
                        .translationY(300F)
                        .withLayer()
                        .start()
//                    activity!!.fab.setTranslationY(fab)
//                    activity!!.bnve.setTranslationY(bnve_height.toFloat())
                } else if (scrollY - oldscrollY < 0 && !isShow) {
                    isShow = true
                    activity!!.fab.animate()
                        .setDuration(1000)
                        .translationY(0F)
                        .withLayer()
                        .start()

                    activity!!.bnve.animate()
                        .setDuration(1000)
                        .translationY(0F)
                        .withLayer()
                        .start()
//                    activity!!.fab.setTranslationY(0F)
//                    activity!!.bnve.setTranslationY(0F)

                }
            }
        })

    }

    override fun initData() {
    }

    override fun initListener() {
        tv.setOnClickListener { ToastUtils.showShort("遮挡事件??") }
    }


}

