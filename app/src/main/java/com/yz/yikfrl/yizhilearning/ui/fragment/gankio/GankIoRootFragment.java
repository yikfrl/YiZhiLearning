package com.yz.yikfrl.yizhilearning.ui.fragment.gankio;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.yz.yikfrl.yizhilearning.R;
import com.zyw.horrarndoo.sdk.base.fragment.BaseCompatFragment;

/**
 * Created by yangz on 2018/3/7.
 */

public class GankIoRootFragment extends BaseCompatFragment{

    public static GankIoRootFragment newInstance(){
        Bundle args = new Bundle();
        GankIoRootFragment fragment = new GankIoRootFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_gank_io;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
        if(findChildFragment(GankIoRootFragment.class) == null){
            loadRootFragment(R.id.fl_container, GankIoFragment.newInstance());
        }
    }
}
