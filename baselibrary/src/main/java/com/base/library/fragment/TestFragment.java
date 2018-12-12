package com.base.library.fragment;

import android.os.Bundle;
import android.view.View;

import com.base.library.R;

public class TestFragment extends BaseFragment {

    public static TestFragment newInstance() {
        return new TestFragment();
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_test;
    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {

    }

    @Override
    public void initData() {

    }
}
