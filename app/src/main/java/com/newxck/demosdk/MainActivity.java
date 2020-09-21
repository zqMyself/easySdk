package com.newxck.demosdk;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.newxck.easysdk.TiyaoAdUtils;
import com.newxck.easysdk.TiyaoUtil;

public class MainActivity extends AppCompatActivity {

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
//        APP id：ca-app-pub-1477380807450550~6634326039
//        激励：Ad Unit ID：ca-app-pub-1477380807450550/5218954976
//        插页：Ad Unit ID：ca-app-pub-1477380807450550/7270403243

        TiyaoUtil.getInstance().TiyaoInit(this);

        TiyaoAdUtils.getInstance().setTestDeviceIds("63E61A851D34E0737F160C1A2D4F5D12");
        //奖励广告
        //设置激励广告ID
        TiyaoAdUtils.getInstance().setTiyaoRewardID(context,"ca-app-pub-1477380807450550/5218954976");
        //激励视频回调接口
        TiyaoAdUtils.getInstance().setTiyaoRewardedAdListener(new TiyaoAdUtils.TiyaoRewardedAdListener() {
            @Override
            public void onError(int code) {
                Toast.makeText(context,"播放失败="+ code,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onReward(String type, int amount) {
                Toast.makeText(context,"播放成功",Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.rewardedAdID).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //展示广告
                TiyaoAdUtils.getInstance().showTiyaoRewardedAd(context);
            }
        });

        //加载插屏广告
        TiyaoAdUtils.getInstance().setTiyaoAdUnitId(context,"ca-app-pub-1477380807450550/7270403243");
        TiyaoAdUtils.getInstance().setTiyaoInterstitialAdListener(new TiyaoAdUtils.TiyaoInterstitialAdListener() {
            @Override
            public void onError(int code) {
                Toast.makeText(context,"播放失败",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onClosed() {

                Toast.makeText(context,"播放成功",Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.adUnitID).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TiyaoAdUtils.getInstance().showInterstitialAd(context);
            }
        });
//
    }
}