package com.yz.yikfrl.yizhilearning.model.gankio;

import android.support.annotation.NonNull;

import com.yz.yikfrl.yizhilearning.contract.gankio.GankIoMainContract;

/**
 * Created by yangz on 2018/3/8.
 */

public class GankIoMainModel implements GankIoMainContract.IGankIoMainModel{
    @NonNull
    public static GankIoMainModel newInstance(){
        return new GankIoMainModel();
    }

    @Override
    public String[] getTabs() {
        return new String[]{"每日推荐","干货定制","福利"};
    }
}
