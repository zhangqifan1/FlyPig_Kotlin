package com.`as`.flypig_kotlin.adapter.btm2

import com.`as`.flypig_kotlin.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * -----------------------------
 * Created by zqf on 2019/8/26.
 * ---------------------------
 */
class Btm2Adapter(layoutResId: Int, data: List<String>?) : BaseQuickAdapter<String, BaseViewHolder>(layoutResId, data) {

    override fun convert(helper: BaseViewHolder, item: String) {
        helper.setText(R.id.tv_item,item)
    }
}
