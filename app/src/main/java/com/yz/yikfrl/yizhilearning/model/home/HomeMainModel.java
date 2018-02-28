package com.yz.yikfrl.yizhilearning.model.home;

import com.yz.yikfrl.yizhilearning.contract.home.HomeMainContract;
import com.zyw.horrarndoo.sdk.base.BaseModel;

/**
 * Created by yangz on 2018/2/28.
 */

public class HomeMainModel extends BaseModel implements HomeMainContract.IHomeMainModel{

    public static HomeMainModel newInstance(){
        return new HomeMainModel();
    }

    @Override
    public String[] getTabs() {
        return new String[]{"知乎日报","热点新闻","微信精选"};
    }
}
