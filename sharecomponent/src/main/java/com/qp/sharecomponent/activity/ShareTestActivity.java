package com.qp.sharecomponent.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.luojilab.component.componentlib.service.AutowiredService;
import com.luojilab.router.facade.annotation.Autowired;
import com.luojilab.router.facade.annotation.RouteNode;
import com.qp.componentservice.bean.Author;
import com.qp.sharecomponent.R;
@RouteNode(path = "/shareBook",desc = "分享的界面")
public class ShareTestActivity extends AppCompatActivity {


    @Autowired
    String bookName;

    @Autowired
    Author author;

    private TextView tvShareTitle;
    private TextView tvShareBook;
    private TextView tvAuthor;
    private TextView tvCounty;

    private final static int RESULT_CODE = 8888;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AutowiredService.Factory.getInstance().create().autowire(this);

        setContentView(R.layout.sharebook_activity_share);



        tvShareTitle = (TextView) findViewById(R.id.share_title);
        tvShareBook = (TextView) findViewById(R.id.share_tv_tag);
        tvAuthor = (TextView) findViewById(R.id.share_tv_author);
        tvCounty = (TextView) findViewById(R.id.share_tv_county);

        tvShareTitle.setText("Book");

        if (bookName != null) {
            tvShareBook.setText(bookName);
        }

        if (author != null) {
            tvAuthor.setText(author.getName());
            tvCounty.setText(author.getCounty());
        }

        Intent intent = new Intent();
        intent.putExtra("result", "Share Success");
        setResult(RESULT_CODE, intent);
    }
}
