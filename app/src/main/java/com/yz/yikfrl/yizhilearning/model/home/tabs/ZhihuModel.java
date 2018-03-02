package com.yz.yikfrl.yizhilearning.model.home.tabs;

import android.support.annotation.NonNull;

import com.yz.yikfrl.yizhilearning.api.ZhihuApi;
import com.yz.yikfrl.yizhilearning.contract.home.tabs.ZhihuContract;
import com.yz.yikfrl.yizhilearning.model.bean.zhihu.ZhihuDailyListBean;
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

public class ZhihuModel extends BaseModel implements ZhihuContract.IZhihuModel{

    @NonNull
    public static ZhihuModel newInstance(){
        return new ZhihuModel();
    }

    @Override
    public Observable<ZhihuDailyListBean> getDailyList(String date) {
        return RetrofitCreateHelper.createApi(ZhihuApi.class, ZhihuApi.HOST).getDailyListWithDate(date)
                .compose(RxHelper.<ZhihuDailyListBean>rxSchedulerHelper());
    }

    @Override
    public Observable<ZhihuDailyListBean> getDailyList() {
        return RetrofitCreateHelper.createApi(ZhihuApi.class, ZhihuApi.HOST).getLastDailyList()
                .compose(RxHelper.<ZhihuDailyListBean>rxSchedulerHelper());
    }

    @Override
    public Observable<Boolean> recordItemIsRead(final String key) {
        return Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(ObservableEmitter<Boolean> emitter) throws Exception {
                emitter.onNext(DBUtils.getDB(AppUtils.getContext()).insertRead(DBConfig.TABLE_ZHIHU,
                        key, ItemState.STATE_IS_READ));
                emitter.onComplete();
            }
        }).compose(RxHelper.<Boolean>rxSchedulerHelper());
    }
}
