package com.qp.sharecomponent.applike;

import com.luojilab.component.componentlib.applicationlike.IApplicationLike;
import com.luojilab.component.componentlib.router.ui.UIRouter;

/**
 * Created by booboomx on 18/1/10.
 */

public class ShareAppLike implements IApplicationLike {

    UIRouter mRouter = UIRouter.getInstance();

    @Override
    public void onCreate() {
        mRouter.registerUI("share");
    }

    @Override
    public void onStop() {

        mRouter.unregisterUI("share");

    }
}
