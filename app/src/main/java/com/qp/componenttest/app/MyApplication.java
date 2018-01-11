package com.qp.componenttest.app;

import android.app.Application;

import com.luojilab.component.componentlib.router.ui.UIRouter;

/**
 * Created by booboomx on 18/1/10.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UIRouter.getInstance().registerUI("app");

    }
}
