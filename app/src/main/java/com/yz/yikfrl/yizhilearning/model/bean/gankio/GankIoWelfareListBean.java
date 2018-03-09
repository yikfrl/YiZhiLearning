package com.yz.yikfrl.yizhilearning.model.bean.gankio;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by yangz on 2018/3/8.
 * 实际上福利返回的json数据格式和custom是一样的，为了区分，这里分开来写bean
 */

public class GankIoWelfareListBean {
    @SerializedName("error")
    private boolean error;

    /**
     * _id : 5832662b421aa929b0f34e99
     * createdAt : 2016-11-21T11:12:43.567Z
     * desc :  深入Android渲染机制
     * publishedAt : 2016-11-24T11:40:53.615Z
     * source : web
     * type : Android
     * url : http://blog.csdn.net/ccj659/article/details/53219288
     * used : true
     * who : Chauncey
     */

    @SerializedName("results")
    private List<GankIoWelfareItemBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<GankIoWelfareItemBean> getResults() {
        return results;
    }

    public void setResults(List<GankIoWelfareItemBean> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "GankIoWelfareListBean{" +
                "error=" + error +
                ", results=" + results +
                '}';
    }
}
