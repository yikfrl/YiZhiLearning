package com.yz.yikfrl.yizhilearning.contract.gankio;

import com.zyw.horrarndoo.sdk.base.BasePresenter;
import com.zyw.horrarndoo.sdk.base.IBaseFragment;
import com.zyw.horrarndoo.sdk.base.IBaseModel;

/**
 * Created by yangz on 2018/3/7.
 */

public interface GankIoMainContract {
    //主页接口
    abstract class GankIoMainPresenter extends BasePresenter<IGankIoMainModel, IGankIoMainView>{
        public abstract void getTabList();
    }

    interface IGankIoMainModel extends IBaseModel{
        String[] getTabs();
    }

    interface IGankIoMainView extends IBaseFragment{
        void showTabList(String[] tabs);
    }
}
