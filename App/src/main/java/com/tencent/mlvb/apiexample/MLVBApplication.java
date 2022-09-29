package com.tencent.mlvb.apiexample;

import android.app.Application;

import android.util.Log;
import androidx.multidex.MultiDex;

import com.tencent.mlvb.debug.GenerateTestUserSig;
import com.tencent.rtmp.TXLiveBase;
import com.texeljoy.hteffect.HTEffect;
import com.texeljoy.hteffect.HTEffect.InitCallback;

public class MLVBApplication extends Application {

    private static MLVBApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        instance = this;
        TXLiveBase.setConsoleEnabled(true);
        TXLiveBase.getInstance().setLicence(instance, GenerateTestUserSig.LICENSEURL, GenerateTestUserSig.LICENSEURLKEY);

        //todo --- hteffect start
        HTEffect.shareInstance().initHTEffect( this, "YOUR_APP_ID", new InitCallback() {
            @Override public void onInitSuccess() {

            }

            @Override public void onInitFailure() {

            }
        });
        //todo --- hteffect end
    }

}
