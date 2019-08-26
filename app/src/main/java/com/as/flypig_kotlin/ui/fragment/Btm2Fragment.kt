package com.`as`.flypig_kotlin.ui.fragment


import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.`as`.base.ui.fragment.BaseFragment
import com.`as`.flypig_kotlin.R
import com.`as`.flypig_kotlin.adapter.btm2.Btm2Adapter
import kotlinx.android.synthetic.main.fragment_btm2.*

/**
 * A simple [Fragment] subclass.
 */
class Btm2Fragment : BaseFragment() {

    override fun setLayoutId(): Int {
        return R.layout.fragment_btm2
    }


    override fun initView() {
        val arrayList = object : ArrayList<String>() {
            init {
                for (i in 0..30) {
                    add("xx" + i)
                }
            }
        }

        val btm2Adapter = Btm2Adapter(R.layout.item_btm2, arrayList)
        rv.adapter = btm2Adapter
        rv.layoutManager = LinearLayoutManager(context)
    }

    override fun initData() {
    }

    override fun initListener() {

        rv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }

            /**
             * //停止滚动
            public static final int SCROLL_STATE_IDLE = 0;

            //正在被外部拖拽,一般为用户正在用手指滚动
            public static final int SCROLL_STATE_DRAGGING = 1;

            //自动滚动开始
            public static final int SCROLL_STATE_SETTLING = 2;
             */
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {

                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    if (motionlayout.currentState == motionlayout.startState) {
                        motionlayout.transitionToEnd()
                    } else {
                        motionlayout.transitionToStart()
                    }
                }
            }
        })



    }


}
