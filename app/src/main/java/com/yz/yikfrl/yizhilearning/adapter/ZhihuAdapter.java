package com.yz.yikfrl.yizhilearning.adapter;

import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yz.yikfrl.yizhilearning.R;
import com.yz.yikfrl.yizhilearning.model.bean.zhihu.ZhihuDailyItemBean;
import com.zyw.horrarndoo.sdk.config.DBConfig;
import com.zyw.horrarndoo.sdk.config.ItemState;
import com.zyw.horrarndoo.sdk.utils.DBUtils;
import com.zyw.horrarndoo.sdk.utils.SpUtils;

import java.util.List;

/**
 * Created by yangz on 2018/3/1.
 * 知乎日报Adapter
 */

public class ZhihuAdapter extends BaseCompatAdapter<ZhihuDailyItemBean, BaseViewHolder>{
    public ZhihuAdapter(@LayoutRes int layoutResId){
        super(layoutResId);
    }

    public ZhihuAdapter(@LayoutRes int layoutResId, @Nullable List<ZhihuDailyItemBean> data){
        super(layoutResId, data);
    }

    public ZhihuAdapter(@Nullable List<ZhihuDailyItemBean> data){
        super(data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ZhihuDailyItemBean item) {
        if(DBUtils.getDB(mContext).isRead(DBConfig.TABLE_ZHIHU, item.getId(), ItemState.STATE_IS_READ)){
            helper.setTextColor(R.id.tv_item_title, Color.GRAY);
        } else {
            if(SpUtils.getNightModel(mContext)){
                helper.setTextColor(R.id.tv_item_title, Color.WHITE);
            }else{
                helper.setTextColor(R.id.tv_item_title, Color.BLACK);
            }
        }
        helper.setText(R.id.tv_item_title, item.getTitle());
        Glide.with(mContext).load(item.getImages()[0]).crossFade().into((ImageView) helper.getView(R.id.iv_item_image));
    }
}
