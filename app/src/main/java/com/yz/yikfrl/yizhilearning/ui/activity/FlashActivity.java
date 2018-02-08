package com.yz.yikfrl.yizhilearning.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tbruyelle.rxpermissions2.RxPermissions;
import com.yz.yikfrl.yizhilearning.MainActivity;
import com.yz.yikfrl.yizhilearning.R;
import com.zyw.horrarndoo.sdk.base.activity.BaseCompatActivity;
import com.zyw.horrarndoo.sdk.helper.RxHelper;
import com.zyw.horrarndoo.sdk.utils.StringUtils;
import com.zyw.horrarndoo.sdk.utils.ToastUtils;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by yangz on 2018/2/8.
 */

public class FlashActivity extends BaseCompatActivity {

    @BindView(R.id.ll_skip)
    LinearLayout llSkip;
    @BindView(R.id.tv_count_down)
    TextView tvCountDown;

    private static final String TAG = "RxPermission";
    private boolean mIsCancle;
    private int mTime = 3;

    @Override
    protected void initView(Bundle savedInstanceState) {
        requestPermissions();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_flash;
    }

    @Override
    public void onBackPressedSupport() {
        mIsCancle = true;
        setIsTransAnim(false);
        finish();
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.ll_skip:
                mIsCancle = true;
                startActivity(new Intent(FlashActivity.this, MainActivity.class));
                finish();
                break;
        }
    }

    private void requestPermissions(){
        RxPermissions rxPermission = new RxPermissions(FlashActivity.this);
        rxPermission.request(Manifest.permission.CAMERA,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean granted) throws Exception {
                        if(!granted){
                            ToastUtils.showToast("App未能获取全部需要的相关权限，部分功能可能不能正常使用.");
                        }
                        //不管是否获取全部权限，进入主页面
                        initCountDown();
                    }
                });
    }

    private void initCountDown(){
        Observable.interval(1, TimeUnit.SECONDS)
                .take(3)
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(Long aLong) throws Exception {
                        return mTime - aLong;
                    }
                })
                .compose(RxHelper.<Long>rxSchedulerHelper())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Long value) {
                        String s = String.valueOf(value);
                        if(tvCountDown != null){
                            tvCountDown.setText(StringUtils.isEmpty(s) ? "" : s));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                        if(!mIsCancle){
                            startActivity(new Intent(FlashActivity.this, MainActivity.class));
                            finish();
                        }
                    }
                });
    }
}
