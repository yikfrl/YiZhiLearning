package com.yz.yikfrl.yizhilearning.model.detail;

import android.support.annotation.NonNull;

import com.yz.yikfrl.yizhilearning.contract.detail.GankIoDetailContract;
import com.zyw.horrarndoo.sdk.base.BaseModel;

/**
 * Created by yangz on 2018/3/9.
 */

public class GankIoDetailModel extends BaseModel implements GankIoDetailContract.IGankIoDetailModel {

    @NonNull
    public static GankIoDetailModel newInstance(){
        return new GankIoDetailModel();
    }
}
