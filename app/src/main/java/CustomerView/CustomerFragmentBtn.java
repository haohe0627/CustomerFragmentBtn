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

import java.util.zip.Inflater;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/17 0017.
 */

public class CustomerFragmentBtn extends FrameLayout {

    private Class<?> mClass;
    private Fragment fragment;
    private Context context;

    public CustomerFragmentBtn(@NonNull Context context) {
        super(context);
        this.context = context;
        init();
    }

    public CustomerFragmentBtn(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public CustomerFragmentBtn(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init(){
        LayoutInflater.from(context).inflate(R.layout.customer_btn, this, true );
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
