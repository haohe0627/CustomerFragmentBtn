package com.example.hh.application.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/3/28 0028.
 */

public abstract class BaseFragment extends Fragment {

    /**
     * onCreate是指创建该fragment类似于Activity.onCreate，你可以在其中初始化除了view之外的东西，onCreateView是创建该fragment对应的视图，你必须在这里创建自己的视图并返回给调用者，例如
     return inflater.inflate(R.layout.fragment_settings, container, false);。
     super.onCreateView有没有调用都无所谓，因为super.onCreateView是直接返回null的。
     */

    private View rootView;
    private Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(rootView != null){

        }else{
            rootView = inflater.inflate(getLayoutId(),container, false);
            unbinder = ButterKnife.bind(this, rootView);
            init();
        }
        return rootView;
    }

    protected abstract int getLayoutId();
    protected  abstract void init();

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
