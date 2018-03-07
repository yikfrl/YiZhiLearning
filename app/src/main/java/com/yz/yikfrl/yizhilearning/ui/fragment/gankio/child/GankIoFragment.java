package com.yz.yikfrl.yizhilearning.ui.fragment.gankio.child;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.yz.yikfrl.yizhilearning.R;
import com.yz.yikfrl.yizhilearning.constant.RxBusCode;
import com.yz.yikfrl.yizhilearning.constant.gankio.GankIoMainContract;
import com.zyw.horrarndoo.sdk.base.BasePresenter;
import com.zyw.horrarndoo.sdk.base.fragment.BaseMVPCompatFragment;
import com.zyw.horrarndoo.sdk.rxbus.RxBus;

import java.util.List;

import butterknife.BindView;

/**
 * Created by yangz on 2018/3/7.
 */

public class GankIoFragment extends BaseMVPCompatFragment<GankIoMainContract.GankIoMainPresenter,
        GankIoMainContract.IGankIoMainModel> implements GankIoMainContract.IGankIoMainView{

    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tl_tabs)
    TabLayout tlTabs;
    @BindView(R.id.vp_fragment)
    ViewPager vpFragment;
    @BindView(R.id.fab_classify)
    FloatingActionButton fabClassify;

    private List<Fragment> fragments;

    public static GankIoFragment newInstance(){
        Bundle args = new Bundle();
        GankIoFragment fragment = new GankIoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        super.initData();
        RxBus.get().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RxBus.get().unRegister(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_gank_io_;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if(vpFragment.getCurrentItem() == 1){
                    if(verticalOffset == 0){
                        fabClassify.show();
                    } else {
                        fabClassify.hide();
                    }
                }
            }
        });
        fabClassify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxBus.get().send(RxBusCode.RX_BUS_CODE_GANKIO_PARENT_FAB_CLICK);
            }
        });

    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    public void showTabList(String[] tabs) {

    }




}
