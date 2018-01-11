package com.qp.component;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.luojilab.router.facade.annotation.RouteNode;

@RouteNode(path = "/RxjavaRetofit", desc = "RxJava练习的界面")
public class RxJavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rxjava_activity_rx_java);
    }
}
