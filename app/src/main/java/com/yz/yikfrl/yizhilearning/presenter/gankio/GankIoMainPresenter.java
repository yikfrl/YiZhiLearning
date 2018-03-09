package com.yz.yikfrl.yizhilearning.presenter.gankio;

import android.support.annotation.NonNull;

import com.yz.yikfrl.yizhilearning.contract.gankio.GankIoMainContract;
import com.yz.yikfrl.yizhilearning.model.gankio.GankIoMainModel;

/**
 * Created by yangz on 2018/3/8.
 */

public class GankIoMainPresenter extends GankIoMainContract.GankIoMainPresenter{

    @NonNull
    public static GankIoMainPresenter newInstance(){
        return new GankIoMainPresenter();
    }
    @Override
    public void getTabList() {
        if(mIView == null || mIModel == null){
            return;
        }

        mIView.showTabList(mIModel.getTabs());
    }

    @Override
    public GankIoMainContract.IGankIoMainModel getModel() {
        return GankIoMainModel.newInstance();
    }

    @Override
    public void onStart() {

    }
}
