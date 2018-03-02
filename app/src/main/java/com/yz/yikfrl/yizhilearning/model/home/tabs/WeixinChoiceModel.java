package com.yz.yikfrl.yizhilearning.model.home.tabs;

import android.support.annotation.NonNull;

import com.yz.yikfrl.yizhilearning.adapter.WeixinAdapter;
import com.yz.yikfrl.yizhilearning.api.WeixinApi;
import com.yz.yikfrl.yizhilearning.contract.home.tabs.WeixinContract;
import com.yz.yikfrl.yizhilearning.model.bean.weixin.WeixinChoiceListBean;
import com.zyw.horrarndoo.sdk.base.BaseModel;
import com.zyw.horrarndoo.sdk.config.DBConfig;
import com.zyw.horrarndoo.sdk.config.ItemState;
import com.zyw.horrarndoo.sdk.helper.RetrofitCreateHelper;
import com.zyw.horrarndoo.sdk.helper.RxHelper;
import com.zyw.horrarndoo.sdk.utils.AppUtils;
import com.zyw.horrarndoo.sdk.utils.DBUtils;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by yangz on 2018/3/2.
 */

public class WeixinChoiceModel extends BaseModel implements WeixinContract.IWeixinModel{

    @NonNull
    public static WeixinChoiceModel newInstance(){
        return new WeixinChoiceModel();
    }

    @Override
    public Observable<Boolean> recordItemIsRead(final String key) {
        return Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(ObservableEmitter<Boolean> emitter) throws Exception {
                emitter.onNext(DBUtils.getDB(AppUtils.getContext()).insertRead(DBConfig.TABLE_WEIXIN,
                        key, ItemState.STATE_IS_READ));
                emitter.onComplete();
            }
        }).compose(RxHelper.<Boolean>rxSchedulerHelper());
    }

    @Override
    public Observable<WeixinChoiceListBean> getWeixinChoiceList(int page, int pageStrip, String dttype, final String key) {
        return RetrofitCreateHelper.createApi(WeixinApi.class, WeixinApi.HOST).getWeixinChoiceList(page,pageStrip,dttype,key)
            .compose(RxHelper.<WeixinChoiceListBean>rxSchedulerHelper());
    }


}
