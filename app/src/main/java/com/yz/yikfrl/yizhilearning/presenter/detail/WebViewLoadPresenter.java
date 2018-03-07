package com.yz.yikfrl.yizhilearning.presenter.detail;

import android.support.annotation.NonNull;

import com.yz.yikfrl.yizhilearning.constant.detail.WebViewLoadContract;
import com.yz.yikfrl.yizhilearning.model.detail.WebViewLoadModel;

/**
 * Created by yangz on 2018/3/7.
 */

public class WebViewLoadPresenter extends WebViewLoadContract.WebViewLoadPresenter{

    @NonNull
    public static WebViewLoadPresenter newInstance(){
        return new WebViewLoadPresenter();
    }

    @Override
    public void loadUrl(String url) {
        if(mIView == null){
            return;
        }

        try {
            mIView.showUrlDetail(url);
        } catch (Exception e) {
            mIView.showNetworkError();
            e.printStackTrace();
        }
    }

    @Override
    public WebViewLoadContract.IWebViewLoadModel getModel() {
        return WebViewLoadModel.newInstance();
    }

    @Override
    public void onStart() {
    }
}
