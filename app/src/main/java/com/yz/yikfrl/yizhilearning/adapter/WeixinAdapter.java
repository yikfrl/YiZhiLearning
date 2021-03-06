package com.yz.yikfrl.yizhilearning.adapter;

import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yz.yikfrl.yizhilearning.R;
import com.yz.yikfrl.yizhilearning.model.bean.weixin.WeixinChoiceItemBean;
import com.zyw.horrarndoo.sdk.config.DBConfig;
import com.zyw.horrarndoo.sdk.config.ItemState;
import com.zyw.horrarndoo.sdk.utils.DBUtils;
import com.zyw.horrarndoo.sdk.utils.SpUtils;

import java.util.List;

/**
 * Created by yangz on 2018/3/1.
 * 微信精选Adapter
 */

public class WeixinAdapter extends BaseCompatAdapter<WeixinChoiceItemBean, BaseViewHolder> {
    public WeixinAdapter(@LayoutRes int layoutResId){
        super(layoutResId);
    }

    public WeixinAdapter(@LayoutRes int layoutResId, @Nullable List<WeixinChoiceItemBean> data){
        super(layoutResId, data);
    }

    public WeixinAdapter(@Nullable List<WeixinChoiceItemBean> data){
        super(data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WeixinChoiceItemBean item) {
        if(DBUtils.getDB(mContext).isRead(DBConfig.TABLE_WEIXIN, item.getId(), ItemState.STATE_IS_READ)){
            helper.setTextColor(R.id.tv_item_title, Color.GRAY);
        }else{
            if(SpUtils.getNightModel(mContext)){
                helper.setTextColor(R.id.tv_item_title, Color.WHITE);
            }else{
                helper.setTextColor(R.id.tv_item_title, Color.BLACK);
            }
        }
        helper.setText(R.id.tv_item_title, item.getTitle());
        helper.setText(R.id.tv_item_who, item.getSource());
        Glide.with(mContext).load(item.getFirstImg()).crossFade().into((ImageView)helper.getView(R.id.iv_item_image));
    }
}
