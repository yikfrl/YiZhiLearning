package com.yz.yikfrl.yizhilearning.contract.home.tabs;

import com.yz.yikfrl.yizhilearning.model.bean.wangyi.WangyiNewsItemBean;
import com.yz.yikfrl.yizhilearning.model.bean.wangyi.WangyiNewsListBean;

import io.reactivex.Observable;

/**
 * Created by yangz on 2018/3/2.
 * 网易新闻接口
 */

public interface WangyiContract {
    abstract class WangyiPresenter extends BaseTabsContract.BaseTabsPresenter<IWangyiModel,
            IWangyiView, WangyiNewsItemBean>{

    }

    interface IWangyiModel extends BaseTabsContract.IBaseTabsModel{
        /**
         * 获取网易新闻list
         * @param id
         * @return
         */
        Observable<WangyiNewsListBean> getNewsList(int id);
    }

    interface IWangyiView extends BaseTabsContract.IBaseTabsView<WangyiNewsItemBean>{
    }
}
