package com.example.hh.application.CustomerView;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.hh.application.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/17 0017.
 */

public class CustomerFragmentBtn extends FrameLayout {

    @BindView(R.id.txt)
    TextView txt;

    private Class<?> mClass;
    private Fragment fragment;
    private Context context;

    public CustomerFragmentBtn( Context context) {
        super(context);
        this.context = context;
        init();
    }

    public CustomerFragmentBtn(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
        initXML(attrs);
    }

    public CustomerFragmentBtn(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
        initXML(attrs);
    }

    private void init(){
        LayoutInflater.from(context).inflate(R.layout.customer_btn, this, true); //一定用这个
        txt  = (TextView)findViewById(R.id.txt);
    }

    private void initXML(AttributeSet attributeSet){
        //获取在界面上的属性值 如果有则赋值
        TypedArray a = context.obtainStyledAttributes(attributeSet, R.styleable.CustomerFragmentBtn);
        if (a.hasValue(R.styleable.CustomerFragmentBtn_text))
            txt.setText(a.getString(R.styleable.CustomerFragmentBtn_text));

        a.recycle();
    }

    public Class<?> getmClass() {
        return mClass;
    }

    public void setmClass(Class<?> mClass) {
        this.mClass = mClass;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}
