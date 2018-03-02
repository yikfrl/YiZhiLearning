package com.yz.yikfrl.yizhilearning.api;

import com.yz.yikfrl.yizhilearning.model.bean.weixin.WeixinChoiceListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yangz on 2018/3/2.
 */

public interface WeixinApi {
    public static final String HOST = "http://v.juhe.cn";

    @GET("/weixin/query")
    Observable<WeixinChoiceListBean> getWeixinChoiceList(@Query("pno") int page, @Query("ps") int ps,
                                                         @Query("dtype") String dttype, @Query("key") String key);
}
