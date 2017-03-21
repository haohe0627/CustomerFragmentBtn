package CustomerView;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.example.hh.customerfragmentbtn.R;

/**
 * Created by Administrator on 2017/3/17 0017.
 */

public class CustomerFragmentBtn extends FrameLayout {

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
        LayoutInflater.from(context).inflate(R.layout.customer_btn, this, true);

    }

    private void initXML(AttributeSet attributeSet){

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
