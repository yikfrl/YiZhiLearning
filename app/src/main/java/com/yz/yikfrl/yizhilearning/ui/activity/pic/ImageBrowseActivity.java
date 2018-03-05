package com.yz.yikfrl.yizhilearning.ui.activity.pic;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.bm.library.PhotoView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.yz.yikfrl.yizhilearning.R;
import com.yz.yikfrl.yizhilearning.constant.BundleKeyConstant;
import com.zyw.horrarndoo.sdk.base.activity.BaseCompatActivity;
import com.zyw.horrarndoo.sdk.helper.RxHelper;
import com.zyw.horrarndoo.sdk.utils.StatusBarUtils;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;

/**
 * Created by yangz on 2018/3/5.
 * 图片查看Activity，只有加载图片以及保存图片等简单逻辑，不采取MVP框架模式
 */

public class ImageBrowseActivity extends BaseCompatActivity {
    @BindView(R.id.pv_pic)
    PhotoView pvPic;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.pb_pic_browse)
    ProgressBar pbPicBrowse;
    @BindView(R.id.fab_save_pic)
    FloatingActionButton fabSavePic;

    private String mImageUrl;

    @Override
    protected void initData() {
        super.initData();
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            mImageUrl = bundle.getString(BundleKeyConstant.ARG_KEY_IMAGE_BROWSE_URL);
        }
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        initTitleBar(toolbar, "");
        StatusBarUtils.setBarColor(this, Color.BLACK);
        pvPic.enable();
        if(mImageUrl.contains("gif")){
            loadGif();
        }else{
            loadImage();
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pic_browse;
    }

    @OnClick(R.id.fab_save_pic)
    public void onClick(View view){
        switch (view.getId()){
            case R.id.fab_save_pic:
                saveImageToLocal(mImageUrl);
                break;
            default:
                break;
        }
    }

    private void saveImageToLocal(final String fileName) {
        Observable.create(new ObservableOnSubscribe<File>() {
            @Override
            public void subscribe(ObservableEmitter<File> e) throws Exception {
                e.onNext(Glide.with(ImageBrowseActivity.this)
                        .load(mImageUrl)
                        .downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                        .get());
                e.onComplete();
            }
        }).compose(RxHelper.<File>rxSchedulerHelper()).subscribe(new Consumer<File>() {
            @Override
            public void accept(File file) throws Exception {
                saveImage(fileName, file)
            }
        });
    }
}
