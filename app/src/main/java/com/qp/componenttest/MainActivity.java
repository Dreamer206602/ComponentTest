package com.qp.componenttest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.luojilab.component.componentlib.router.Router;
import com.luojilab.component.componentlib.router.ui.UIRouter;
import com.luojilab.router.facade.annotation.RouteNode;
import com.qp.componentservice.readerbook.ReadBookService;

@RouteNode(path = "/main",desc = "首页")
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Fragment fragment;
    FragmentTransaction ft;

    Button installReadBookBtn;
    Button uninstallReadBtn;
    Button btnRxJava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        installReadBookBtn = (Button) findViewById(R.id.install_share);
        uninstallReadBtn = (Button) findViewById(R.id.uninstall_share);
        btnRxJava = (Button) findViewById(R.id.btn_rxjava);
        btnRxJava.setOnClickListener(this);
        installReadBookBtn.setOnClickListener(this);
        uninstallReadBtn.setOnClickListener(this);
        showFragment();
    }


    private void showFragment() {
        if (fragment != null) {
            ft = getSupportFragmentManager().beginTransaction();
            ft.remove(fragment).commit();
            fragment = null;
        }
        Router router = Router.getInstance();
        if (router.getService(ReadBookService.class.getSimpleName()) != null) {
            ReadBookService service = (ReadBookService) router.getService(ReadBookService.class.getSimpleName());
            fragment = service.getReadBookFragment();
            ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.tab_content, fragment).commitAllowingStateLoss();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.install_share:
                Router.registerComponent("com.qp.sharecomponent.applike.ShareAppLike");
                Router.registerComponent("com.qp.component.applike.RxJavaAppLike");
                break;
            case R.id.uninstall_share:
                Router.unregisterComponent("com.qp.sharecomponent.applike.ShareAppLike");
                Router.unregisterComponent("com.qp.component.applike.RxJavaAppLike");
                break;

            case R.id.btn_rxjava:
                UIRouter.getInstance().openUri(this,"DDComp://rxjava/RxjavaRetofit",null);
                break;
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            Toast.makeText(this, data.getStringExtra("result"), Toast.LENGTH_SHORT).show();
        }
    }
}
