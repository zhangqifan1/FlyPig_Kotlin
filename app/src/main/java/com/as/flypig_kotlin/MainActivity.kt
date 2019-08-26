package com.`as`.flypig_kotlin

import android.support.annotation.NonNull
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v4.widget.DrawerLayout
import android.view.MenuItem
import android.view.View
import com.`as`.base.ui.activity.BaseActivity
import com.`as`.flypig_kotlin.adapter.MyPageAdapter
import com.`as`.flypig_kotlin.ui.fragment.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

    override fun setLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        val arrayList = ArrayList<Fragment>();
        val btm1Fragment = Btm1Fragment()
        val btm2Fragment = Btm2Fragment()
        val btm3Fragment = Btm3Fragment()
        val btm4Fragment = Btm4Fragment()
        val btm5Fragment = Btm5Fragment()//这个是空的

        arrayList.add(btm1Fragment)
        arrayList.add(btm2Fragment)
        arrayList.add(btm3Fragment)
        arrayList.add(btm4Fragment)
        arrayList.add(btm5Fragment)

        bnve.enableItemShiftingMode(false);//为true 时  只有当前选中项 会显示文字
//        mViewBinding.bnve.enableShiftingMode(false);//为true 时,当前选中项宽度改变
        bnve.enableAnimation(false);//开启或关闭点击动画(文字放大效果和图片移动效果)。默认为 true.

        val myPageAdapter = MyPageAdapter(getSupportFragmentManager(), arrayList);
        main_vp.setAdapter(myPageAdapter);

        bnve.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener {
            private var previousPosition = -1

            override fun onNavigationItemSelected(@NonNull item: MenuItem): Boolean {
                var position = 0
                when (item.getItemId()) {
                    R.id.icon1 -> position = 0
                    R.id.icon2 -> position = 1
                    R.id.i_empty -> position = 2
                    R.id.icon3 -> position = 3
                    R.id.icon4 -> position = 4
                }
                if (previousPosition != position) {
                    main_vp.setCurrentItem(position, false)
                    previousPosition = position
                }
                return true
            }
        })

        // 针对悬浮按钮
        main_vp.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                var numPages = 5//总的页数
                var progress = (position + positionOffset) / (numPages - 1)
                my_viewpager_head.setProgress(progress)
            }
            override fun onPageSelected(position: Int) {
//                var aposition = position
//
//                if (aposition == 2) {// 2 is center
//                    aposition++// if page is 2, need set bottom item to 3, and the same to 3 -> 4
//                }
                if (position == 2) {
                    fab.setImageResource(R.drawable.btm3)
                }else{
                    fab.setImageResource(R.drawable.btm3_false)
                }
                bnve.setCurrentItem(position)
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

        //悬浮窗点击事件
        fab.setOnClickListener {
            bnve.setCurrentItem(2)
        }


        main_drawer.addDrawerListener(object :DrawerLayout.DrawerListener{
            override fun onDrawerStateChanged(p0: Int) {
            }

            override fun onDrawerSlide(p0: View, p1: Float) {

                var scale = 1 - p1;//1~0
                main_drawer_right.setTranslationX(main_drawer_left.getMeasuredWidth() * (1 - scale));//0~width
            }

            override fun onDrawerClosed(p0: View) {

//                main_drawer_right.animate()
//                    .setDuration(500)
//                    .scaleX(1F)
//                    .scaleY(1F)
//                    .translationX(0F)
//                    .withLayer()
//                    .start()

            }

            override fun onDrawerOpened(p0: View) {

//                main_drawer_right.animate()
//                    .setDuration(500)
//                    .scaleX(0.8F)
//                    .scaleY(0.8F)
//                    .translationX(200F)
//                    .withLayer()
//                    .start()
            }

        })

        bnve.getBottomNavigationItemView(2).setBackgroundDrawable(null)

    }

    override fun initData() {

    }

    override fun initListener() {
    }


//        startActivity(Intent(this@MainActivity,UserInfoActivity::class.java))

}
