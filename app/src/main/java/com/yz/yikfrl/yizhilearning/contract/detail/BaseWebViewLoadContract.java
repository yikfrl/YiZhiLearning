package com.yz.yikfrl.yizhilearning.contract.detail;

import android.support.v4.app.FragmentActivity;
import android.webkit.WebView;

import com.zyw.horrarndoo.sdk.base.BasePresenter;
import com.zyw.horrarndoo.sdk.base.IBaseActivity;
import com.zyw.horrarndoo.sdk.base.IBaseModel;

/**
 * Created by yangz on 2018/3/5.
 */

public interface BaseWebViewLoadContract {
    abstract class BaseWebViewLoadPresenter<M extends IBaseWebViewLoadModel, V extends
            IBaseWebViewLoadView> extends BasePresenter<M, V>{
        /**
         * 保存图片点击
         * @param activity {@link FragmentActivity}
         * @param imgUrl imgUrl
         */
        public abstract void saveImageClicked(FragmentActivity activity, String imgUrl);

        /**
         * 跳转图片详情按钮点击
         * @param imgUrl imgUrl
         */
        public abstract void gotoImageBrowseClicked(String imgUrl);

        /**
         * 图片长按事件
         * @param hitTestResult {@link WebView.HitTestResult}
         */
        public abstract void imageLongClicked(WebView.HitTestResult hitTestResult);
    }


    interface IBaseWebViewLoadModel extends IBaseModel {

    }

    interface IBaseWebViewLoadView extends IBaseActivity{
        /**
         * 显示网络错误
         */
        void showNetworkError();
        /**
         * 显示popupWindow
         */
        void showPopupWindow();
        /**
         * 隐藏popupWindow();
         */
        void dismissPopupWindow();
        /**
         * 返回popupWindow显示状态
         * @return popupWindow显示状态
         */
        boolean popupWindowIsShowing();
        /**
         * 跳转到图片详情页
         * @param imgUrl 图片url
         */
        void gotoImageBrowse(String imgUrl);
    }
}
