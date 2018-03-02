package com.yz.yikfrl.yizhilearning.model.bean.wangyi;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by yangz on 2018/3/1.
 */

public class WangyiNewsListBean {

    @SerializedName("T1348647909107")
    ArrayList<WangyiNewsItemBean> newsList;

    public ArrayList<WangyiNewsItemBean> getNewsList() {
        return newsList;
    }

    public void setNewsList(ArrayList<WangyiNewsItemBean> newsList) {
        this.newsList = newsList;
    }
}
