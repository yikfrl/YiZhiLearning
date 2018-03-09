package com.yz.yikfrl.yizhilearning.contract.gankio.tabs;

import com.yz.yikfrl.yizhilearning.model.bean.gankio.GankIoDayItemBean;
import com.yz.yikfrl.yizhilearning.presenter.gankio.GankIoMainPresenter;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by yangz on 2018/3/8.
 */

public interface GankIoDayContract {
    abstract class GankIoDayPresenter extends BaseTabsContract.BaseTabsPresenter<IGankIoDayModel, IGankIoDayView, GankIoDayItemBean>{
        /**
         * “更多”按钮点击事件
         * @param position
         * @param item
         */
        public abstract void onMoreClick(int position, GankIoDayItemBean item);

        /**
         * “刷新”按钮点击事件
         * @param position
         * @param item
         */
        public abstract void onRefreshClick(int position, GankIoDayItemBean item);
    }

    interface IGankIoDayModel extends BaseTabsContract.IBaseTabsModel{
        /**
         * 请求GankIo每日数据list
         * @param year
         * @param month
         * @param day
         * @return
         */
        Observable<List<GankIoDayItemBean>> getGankIoDayList(String year, String month, String day);

        /**
         * 获取指定page Android数据
         * @param page
         * @return
         */
        GankIoDayItemBean getGankIoDayAndroid(int page);

        /**
         * 获取指定page iOS数据
         * @param page
         * @return
         */
        GankIoDayItemBean getGankIoDayIOS(int page);
    }

    interface IGankIoDayView extends BaseTabsContract.IBaseTabsView<GankIoDayItemBean>{
        /**
         * 点击事件后，刷新item
         * @param position
         * @param bean
         */
        void itemNotifyChanged(int position, GankIoDayItemBean bean);
    }
}
