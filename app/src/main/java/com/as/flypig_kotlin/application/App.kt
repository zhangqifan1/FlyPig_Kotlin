package com.`as`.flypig_kotlin.application

import android.content.Context
import android.support.multidex.MultiDex
import com.`as`.base.application.BaseApplication
import com.`as`.flypig_kotlin.crash.CrashManager
import com.luliang.shapeutils.DevShapeUtils

/**
 *-----------------------------
 * Created by zqf on 2019/8/20.
 *---------------------------
 */
class App : BaseApplication() {

    /**
     * 重写的方法 主要是用来一些第三方的 初始化
     */
    override fun initThirdParty() {

        CrashManager.install(this)

        DevShapeUtils.init(this)
    }

     override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}