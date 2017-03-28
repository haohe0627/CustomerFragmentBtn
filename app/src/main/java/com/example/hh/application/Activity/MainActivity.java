package com.example.hh.application.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.hh.application.Base.BaseFragmentActivity;
import com.example.hh.application.CustomerView.CustomerFragmentBtn;
import com.example.hh.application.Fragment.OneFragment;
import com.example.hh.application.Fragment.SecondFragment;
import com.example.hh.application.Fragment.ThirdFragment;
import com.example.hh.application.R;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseFragmentActivity {

    @BindView(R.id.btn1)
    CustomerFragmentBtn btn1;
    @BindView(R.id.btn2)
    CustomerFragmentBtn btn2;
    @BindView(R.id.btn3)
    CustomerFragmentBtn btn3;

    private CustomerFragmentBtn lastClickBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        btn1.setmClass(OneFragment.class);
        btn2.setmClass(SecondFragment.class);
        btn3.setmClass(ThirdFragment.class);

        clearOldFragment();
        selectBtn(btn1);
    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3})
    void clickBtn(View view){
        selectBtn((CustomerFragmentBtn)view);
    }

    //点击按钮
    private void selectBtn(CustomerFragmentBtn btn) {

        CustomerFragmentBtn oldBtn = null;
        if(lastClickBtn != null){
            oldBtn = lastClickBtn;
            if(oldBtn == btn){
                reSelect(oldBtn);
                return;
            }
            oldBtn.setSelected(false);
        }

        btn.setSelected(true);
        changeFragment(oldBtn, btn);
        lastClickBtn = btn;
    }

    //切换
    private void changeFragment(CustomerFragmentBtn oldBtn, CustomerFragmentBtn newBtn){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        if(oldBtn != null){
            if(oldBtn.getFragment() != null){
                ft.detach(oldBtn.getFragment());
            }
        }

        if(newBtn != null){
            if(newBtn.getFragment() == null){
                Fragment fragment = Fragment.instantiate(this, newBtn.getmClass().getName(), null); //实例新的Fragment
                ft.add(R.id.content, fragment, newBtn.getmClass().getName());
                newBtn.setFragment(fragment);
            }else{
                ft.attach(newBtn.getFragment());
            }
        }

        ft.commit();
    }

    //清空
    private void clearOldFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        List<Fragment>fragments = getSupportFragmentManager().getFragments();
        if(ft == null || fragments == null || fragments.size() == 0){
            return;
        }
        for(Fragment fg: fragments){
            ft.remove(fg);
        }
        ft.commitNow();
    }

    //重选
    private void reSelect(CustomerFragmentBtn btn){

        //间隔ns重新加载或是怎样
    }
}
