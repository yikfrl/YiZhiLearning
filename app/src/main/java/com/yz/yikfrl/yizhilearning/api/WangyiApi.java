package com.yz.yikfrl.yizhilearning.api;

import com.yz.yikfrl.yizhilearning.model.bean.wangyi.WangyiNewsListBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by yangz on 2018/3/2.
 */

public interface WangyiApi {
    public static final String HOST = "http://c.m.163.com";

    @GET("/nc/article/headline/T1348647909107/{id}-20.html")
    Observable<WangyiNewsListBean> getNewsList(@Path("id") int id);

    @GET("/nc/article/{id}/full.html")
    Observable<ResponseBody> getNewsDetail(@Path("id") String id);
}
