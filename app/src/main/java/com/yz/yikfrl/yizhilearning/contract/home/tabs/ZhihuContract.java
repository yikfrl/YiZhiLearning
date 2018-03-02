package com.yz.yikfrl.yizhilearning.contract.home.tabs;

import com.yz.yikfrl.yizhilearning.model.bean.zhihu.ZhihuDailyItemBean;
import com.yz.yikfrl.yizhilearning.model.bean.zhihu.ZhihuDailyListBean;

import io.reactivex.Observable;

/**
 * Created by yangz on 2018/2/28.
 * 知乎头条接口
 */

public interface ZhihuContract {

    abstract class ZhihuPresenter extends BaseTabsContract.BaseTabsPresenter<IZhihuModel,
            IZhihuView, ZhihuDailyItemBean>{
    }

    interface IZhihuModel extends BaseTabsContract.IBaseTabsModel{
        /**
         * 根据日期获取日报list
         *
         * @param date
         * @return
         */
        Observable<ZhihuDailyListBean> getDailyList(String date);

        /**
         * 获取日报list
         * @return
         */
        Observable<ZhihuDailyListBean> getDailyList();
    }

    interface IZhihuView extends BaseTabsContract.IBaseTabsView<ZhihuDailyItemBean>{
    }
}
