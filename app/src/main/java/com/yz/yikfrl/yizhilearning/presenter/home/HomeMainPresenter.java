package com.yz.yikfrl.yizhilearning.presenter.home;

import android.support.annotation.NonNull;

import com.yz.yikfrl.yizhilearning.contract.home.HomeMainContract;
import com.yz.yikfrl.yizhilearning.model.home.HomeMainModel;

/**
 * Created by yangz on 2018/2/28.
 */

public class HomeMainPresenter extends HomeMainContract.HomeMainPresenter {

    @NonNull
    public static HomeMainPresenter newInstance(){
        return new HomeMainPresenter();
    }

    @Override
    public void getTabList() {
        if(mIView == null || mIModel == null)
            return;

        mIView.showTabList(mIModel.getTabs());
    }

    @Override
    public HomeMainContract.IHomeMainModel getModel() {
        return HomeMainModel.newInstance();
    }

    @Override
    public void onStart() {

    }
}
