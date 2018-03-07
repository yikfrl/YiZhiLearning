package com.yz.yikfrl.yizhilearning.model.detail;

import android.support.annotation.NonNull;

import com.yz.yikfrl.yizhilearning.constant.detail.WebViewLoadContract;
import com.zyw.horrarndoo.sdk.base.BaseModel;

/**
 * Created by yangz on 2018/3/7.
 */

public class WebViewLoadModel extends BaseModel implements
        WebViewLoadContract.IWebViewLoadModel{

    @NonNull
    public static WebViewLoadModel newInstance(){
        return new WebViewLoadModel();
    }
}
