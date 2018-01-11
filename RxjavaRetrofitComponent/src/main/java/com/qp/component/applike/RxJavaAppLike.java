package com.qp.component.applike;

import com.luojilab.component.componentlib.applicationlike.IApplicationLike;
import com.luojilab.component.componentlib.router.ui.UIRouter;

/**
 * Created by booboomx on 18/1/11.
 */

public class RxJavaAppLike implements IApplicationLike {

    UIRouter uiRouter = UIRouter.getInstance();

    @Override
    public void onCreate() {

        uiRouter.registerUI("rxjava");

    }

    @Override
    public void onStop() {

        uiRouter.unregisterUI("rxjava");

    }
}
