package com.yz.yikfrl.yizhilearning.contract.home;

import com.zyw.horrarndoo.sdk.base.BasePresenter;
import com.zyw.horrarndoo.sdk.base.IBaseFragment;
import com.zyw.horrarndoo.sdk.base.IBaseModel;

/**
 * Created by yangz on 2018/2/27.
 */

public class HomeMainContract {
    //主页接口
    abstract class HomeMainPresenter extends BasePresenter<IHomeMainModel, IHomeMainView>{
        public abstract void getTabList();
    }

    interface IHomeMainModel extends IBaseModel{
        String[] getTabs();
    }

    interface IHomeMainView extends IBaseFragment{
        void showTabList(String[] tabs);
    }
}
