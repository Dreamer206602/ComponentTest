package com.qp.readcomponent.runalone.application;

import android.app.Application;

import com.luojilab.component.componentlib.router.Router;

/**
 * Created by booboomx on 18/1/10.
 */

public class ReadApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //如果isRegisterCompoAuto为false，则需要通过反射加载组件
        Router.registerComponent("com.qp.sharecomponent.applike.ShareAppLike");
//        Router.registerComponent("com.luojilab.share.kotlin.applike.KotlinApplike");

    }
}
