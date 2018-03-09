package com.yz.yikfrl.yizhilearning.presenter.detail;

import android.support.annotation.NonNull;

import com.yz.yikfrl.yizhilearning.contract.detail.GankIoDetailContract;
import com.yz.yikfrl.yizhilearning.model.detail.GankIoDetailModel;

/**
 * Created by yangz on 2018/3/9.
 */

public class GankIoDetailPresenter extends GankIoDetailContract.GankIoDetailPresenter {
    @NonNull
    public static GankIoDetailPresenter newInstance(){
        return new GankIoDetailPresenter();
    }

    @Override
    public void loadGankIoDetail(String url) {
        if(mIView == null){
            return;
        }
        try {
            mIView.showGankIoDetail(url);
        } catch (Exception e) {
            mIView.showNetworkError();
            e.printStackTrace();
        }
    }

    @Override
    public GankIoDetailContract.IGankIoDetailModel getModel() {
        return GankIoDetailModel.newInstance();
    }

    @Override
    public void onStart() {
    }
}
