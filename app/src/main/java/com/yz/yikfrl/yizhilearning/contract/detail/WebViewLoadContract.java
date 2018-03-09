package com.yz.yikfrl.yizhilearning.contract.detail;

import com.yz.yikfrl.yizhilearning.presenter.detail.BaseWebViewLoadPresenter;

/**
 * Created by yangz on 2018/3/5.
 *
 * webview加载更多详情，传入url显示webview
 */

public interface WebViewLoadContract {
    abstract class WebViewLoadPresenter extends BaseWebViewLoadPresenter<IWebViewLoadModel,
            IWebViewLoadView>{
        /**
         * 加载url
         * @param url url
         */
        public abstract void loadUrl(String url);
    }

    interface IWebViewLoadModel extends BaseWebViewLoadContract.IBaseWebViewLoadModel{
    }

    interface IWebViewLoadView extends BaseWebViewLoadContract.IBaseWebViewLoadView{
        /**
         * 显示url详情
         *
         * @param url url
         */
        void showUrlDetail(String url);
    }
}
