package com.yz.yikfrl.yizhilearning.contract.detail;

import com.yz.yikfrl.yizhilearning.presenter.detail.BaseWebViewLoadPresenter;

/**
 * Created by yangz on 2018/3/9.
 */

public interface GankIoDetailContract {
    abstract class GankIoDetailPresenter extends BaseWebViewLoadPresenter<IGankIoDetailModel, IGankIoDetailView>{
        /**
         * 加载GankIo详情
         *
         * @param url
         */
        public abstract void loadGankIoDetail(String url);
    }

    interface IGankIoDetailModel extends BaseWebViewLoadContract.IBaseWebViewLoadModel{

    }

    interface IGankIoDetailView extends BaseWebViewLoadContract.IBaseWebViewLoadView{
        /**
         * 显示GankIo详细内容
         * @param url
         */
        void showGankIoDetail(String url);
    }
}
