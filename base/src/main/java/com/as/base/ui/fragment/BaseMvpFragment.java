package com.as.base.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.as.base.ui.TUtil;
import com.as.base.ui.mvp.BaseIModel;
import com.as.base.ui.mvp.BaseIView;
import com.as.base.ui.mvp.BasePresenter;
import me.yokeyword.fragmentation.SupportFragment;
import org.greenrobot.eventbus.EventBus;

import java.lang.reflect.ParameterizedType;


/**
 * -----------------------------
 * Created by zqf on 2018/1/22.
 * ---------------------------
 */

public abstract class BaseMvpFragment<P extends BasePresenter, M extends BaseIModel> extends SupportFragment implements BaseIView {
    public LayoutInflater inflater;
    protected M mMode;
    protected P mPresenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(setLayoutId(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initPresenter();
        initData();
        initListener();
    }

    /**
     * 传入布局id
     */
    protected abstract int setLayoutId();


    /**
     * 初始化view 之后
     */
    public abstract void initView();

    /**
     * 初始化按钮监听
     */
    protected abstract void initListener();

    /**
     * 初始化对象
     */
    protected abstract void initData();

    /**
     * 简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
     */
    public void initPresenter() {
        if (this instanceof BaseIView && this.getClass().getGenericSuperclass() instanceof ParameterizedType &&
                ((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments().length > 0) {
            mMode = TUtil.getT(this, 1);
            mPresenter = TUtil.getT(this, 0);

            if (mPresenter != null) mPresenter.setMV(mMode, this);
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        if (isAdded()) {
            if (!EventBus.getDefault().isRegistered(this) && useEventBus()) {
                //如果要使用 Eventbus 请将此方法返回 true
                EventBus.getDefault().register(this);//注册 Eventbus
            }
        }

    }

    @Override
    public void onDestroy() {
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
        if (EventBus.getDefault().isRegistered(this) && useEventBus()) {
            EventBus.getDefault().unregister(this);
//            EventBus.getDefault().removeAllStickyEvents();
        }
        super.onDestroy();
    }


    /**
     * 是否使用 {@link EventBus},默认为使用(false)，
     */
    public boolean useEventBus() {
        return false;
    }

    public void startActivity(Class clazz) {
        startActivity(new Intent(this.getActivity(), clazz));
    }


    @Override
    public Context getCt() {
        return getActivity();
    }
}