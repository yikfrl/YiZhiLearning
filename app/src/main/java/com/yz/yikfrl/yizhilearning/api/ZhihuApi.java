package com.yz.yikfrl.yizhilearning.api;

import com.yz.yikfrl.yizhilearning.model.bean.zhihu.ZhihuDailyDetailBean;
import com.yz.yikfrl.yizhilearning.model.bean.zhihu.ZhihuDailyListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by yangz on 2018/3/2.
 */

public interface ZhihuApi {
    public final String HOST = "http://news-at.zhihu.com";

    @GET("/api/4/news/latest")
    Observable<ZhihuDailyListBean> getLastDailyList();

    @GET("/api/4/news/before/{date}")
    Observable<ZhihuDailyListBean> getDailyListWithDate(@Path("data") String date);

    @GET("/api/4/news/{id}")
    Observable<ZhihuDailyDetailBean> getZhihuDailyDetail(@Path("id") String id);

}
