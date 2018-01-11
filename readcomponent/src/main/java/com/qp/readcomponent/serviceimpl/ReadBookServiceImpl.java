package com.qp.readcomponent.serviceimpl;

import android.support.v4.app.Fragment;

import com.qp.componentservice.readerbook.ReadBookService;
import com.qp.readcomponent.fragment.ReaderFragment;

/**
 * Created by booboomx on 18/1/10.
 */

public class ReadBookServiceImpl implements ReadBookService {
    @Override
    public Fragment getReadBookFragment() {
        return new ReaderFragment();
    }
}
