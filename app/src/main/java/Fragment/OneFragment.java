package Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hh.customerfragmentbtn.R;

/**
 * Created by Administrator on 2017/3/17 0017.
 */

public class OneFragment extends Fragment {

    /**
     * onCreate是指创建该fragment类似于Activity.onCreate，你可以在其中初始化除了view之外的东西，onCreateView是创建该fragment对应的视图，你必须在这里创建自己的视图并返回给调用者，例如
     return inflater.inflate(R.layout.fragment_settings, container, false);。
     super.onCreateView有没有调用都无所谓，因为super.onCreateView是直接返回null的。
     */

    protected FragmentActivity fgActivity;
    protected View rootView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.fgActivity = getActivity();


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(rootView != null){
            ViewGroup parent = (ViewGroup) rootView.getParent(); // 父布局
            if(parent != null){
                parent.removeView(rootView);
            }
        }else{

            rootView = inflater.inflate(R.layout.page_one, container, false);

        }

        return rootView;
    }

}
