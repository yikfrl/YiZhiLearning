package com.yz.yikfrl.yizhilearning.presenter.gankio.tabs;

import android.os.Bundle;

import com.yz.yikfrl.yizhilearning.constant.BundleKeyConstant;
import com.yz.yikfrl.yizhilearning.constant.RxBusCode;
import com.yz.yikfrl.yizhilearning.contract.gankio.tabs.GankIoDayContract;
import com.yz.yikfrl.yizhilearning.model.bean.gankio.GankIoDayItemBean;
import com.yz.yikfrl.yizhilearning.model.gankio.tabs.GankIoDayModel;
import com.yz.yikfrl.yizhilearning.ui.activity.detail.GankIoDetailActivity;
import com.yz.yikfrl.yizhilearning.ui.activity.pic.ImageBrowseActivity;
import com.zyw.horrarndoo.sdk.rxbus.RxBus;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * Created by yangz on 2018/3/9.
 */

public class GankIoDayPresenter extends GankIoDayContract.GankIoDayPresenter{
    private String mYear = "2016";
    private String mMonth = "11";
    private String mDay = "24";

    private int mAndroidPages = 0;
    private int mIOSPages = 0;
    private List<GankIoDayItemBean> mList = new ArrayList<>();

    public static GankIoDayPresenter newInstance(){
        return new GankIoDayPresenter();
    }

    @Override
    public void loadLastestList() {
        if(mIModel == null || mIView == null){
            return;
        }

        //GankIo每日数据大部分时间返回空值，这里直接写死一个日期数据
        mRxManager.register(mIModel.getGankIoDayList(mYear, mMonth, mDay)
                .subscribe(new Consumer<List<GankIoDayItemBean>>() {
                    @Override
                    public void accept(List<GankIoDayItemBean> list) throws Exception {
                        if(mIView == null){
                            return;
                        }
                        mList = list;
                        mIView.updateContentList(mList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if(mIView != null){
                            if(mIView.isVisiable()){
                                mIView.showToast("Network error.");
                            }
                            mIView.showNetworkError();
                        }
                    }
                }));
    }

    @Override
    public void loadMoreList() {
        //每日数据没有更多
    }

    @Override
    public void onItemClick(int position, GankIoDayItemBean item) {
        Bundle bundle = new Bundle();
        if(item.getType().equals("福利")){
            bundle.putString(BundleKeyConstant.ARG_KEY_IMAGE_BROWSE_URL, item.getUrl());
            mIView.startNewActivity(ImageBrowseActivity.class, bundle);
        } else {
            bundle.putString(BundleKeyConstant.ARG_KEY_GANKIO_DETAIL_URL, item.getUrl());
            bundle.putString(BundleKeyConstant.ARG_KEY_GANKIO_DETAIL_TITLE, item.getDesc());
            mIView.startNewActivity(GankIoDetailActivity.class, bundle);
        }
    }

    @Override
    public void onMoreClick(int position, GankIoDayItemBean item) {
        if(item.getType().equals("福利")){//更多福利直接跳到福利界面
            RxBus.get().send(RxBusCode.RX_BUS_CODE_GANKIO_WELFARE_TYPE);
            RxBus.get().send(RxBusCode.RX_BUS_CODE_GANKIO_SELECT_TO_CHILD, 2);
        } else {//跳到custom界面
            RxBus.get().send(RxBusCode.RX_BUS_CODE_GANKIO_CUSTOM_TYPE, item.getType());
            RxBus.get().send(RxBusCode.RX_BUS_CODE_GANKIO_SELECT_TO_CHILD, 1);
        }
    }

    @Override
    public void onRefreshClick(int position, GankIoDayItemBean item) {
        if(mIModel == null || mIView == null){
            return;
        }

        if(item.getType().equals("Android")){
            mAndroidPages++;
            mIView.itemNotifyChanged(position, mIModel.getGankIoDayAndroid(mAndroidPages % 6));
        } else {
            mIOSPages++;
            mIView.itemNotifyChanged(position, mIModel.getGankIoDayIOS(mIOSPages % 3));
        }
    }

    @Override
    public GankIoDayContract.IGankIoDayModel getModel() {
        return GankIoDayModel.newInstance();
    }

    @Override
    public void onStart() {
    }
}
