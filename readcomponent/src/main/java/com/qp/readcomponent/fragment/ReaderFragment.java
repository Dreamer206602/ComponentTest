package com.qp.readcomponent.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luojilab.component.componentlib.router.Router;
import com.luojilab.component.componentlib.router.ui.UIRouter;
import com.luojilab.component.componentlib.service.JsonService;
import com.qp.componentservice.bean.Author;
import com.qp.readcomponent.R;

/**
 */
public class ReaderFragment extends Fragment {

    private View rootView;
    private final static int REQUEST_CODE = 7777;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (rootView == null) {
            rootView = inflater.inflate(R.layout.readerbook_fragment_reader, container, false);





            rootView.findViewById(R.id.tv_1).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    goToShareActivityWithBundle();

                }
            });
            rootView.findViewById(R.id.tv_2).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    goToShareActivityWithUri();

                }
            });
            rootView.findViewById(R.id.tv_3).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    goToShareActivityWithForResult();
                }
            });


        }


        return rootView;

    }


    @Override
    public void onResume() {
        super.onResume();

//        Router.registerComponent("com.qp.sharecomponent.applike.ShareAppLike");

    }

    public void goToShareActivityWithBundle() {
        Author author=new Author();
        author.setName("I am bundle");
        author.setCounty("China");

        Bundle bundle=new Bundle();
        bundle.putString("booName","FuckWithBundle");
        bundle.putString("author", JsonService.Factory.getInstance().create().toJsonString(author));
        UIRouter.getInstance().openUri(getContext(),"DDComp://share/shareBook",bundle);

    }

    public void goToShareActivityWithUri() {

        Author author=new Author();
        author.setName( "I am Uri");
        author.setCounty("USA");
        UIRouter.getInstance()
                .openUri(getContext(),
                        "DDComp://share/shareBook?bookName=Gone With Wind&author="
                                +JsonService.Factory.getInstance().create().toJsonString(author),null);

    }

    public void goToShareActivityWithForResult() {


        Author author=new Author();
        author.setName( "I am ForResult");
        author.setCounty("Japan");
        UIRouter.getInstance()
                .openUri(getContext(),
                        "DDComp://share/shareBook?bookName=Gone With Wind&author="
                                +JsonService.Factory.getInstance().create().toJsonString(author),null,REQUEST_CODE);


    }

}
