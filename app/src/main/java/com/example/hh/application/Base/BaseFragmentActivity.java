package com.example.hh.application.Base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/3/21 0021.
 */

public abstract class BaseFragmentActivity extends AppCompatActivity{

    protected Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    protected abstract int getLayoutId();

    protected abstract void init();

    protected void redirectTo(Class<? extends Activity> activity){
        redirectTo(activity, false);
    }

    protected void redirectTo(Class<? extends Activity> activity, boolean isFinish){
        startActivity(new Intent(this, activity));
        if(isFinish)
            finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, @NonNull KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            back();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void back(View view) {
        back();
    }

    public void back() {
        finish();
    }
}
