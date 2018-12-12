package com.todayin.base;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.base.library.activity.BaseActivity;
import com.base.library.fragment.SupportFragment;
import com.base.library.fragment.TestFragment;
import com.base.library.utils.StatusBarUtil;
import com.base.library.widget.bottom.BottomBar;
import com.base.library.widget.bottom.BottomBarTab;
import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.contentContainer)
    FrameLayout contentContainer;
    @BindView(R.id.bottomBar)
    BottomBar mBottomBar;
    private SupportFragment[] mFragments = new SupportFragment[4];
    @Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {
        StatusBarUtil.setTranslucentForImageViewInFragment(MainActivity.this, 0, null);
        if (savedInstanceState == null) {
            mFragments[0] = TestFragment.newInstance();
            mFragments[1] = TestFragment.newInstance();
            mFragments[2] = TestFragment.newInstance();
            mFragments[3] = TestFragment.newInstance();

            getSupportDelegate().loadMultipleRootFragment(R.id.contentContainer, 0,
                    mFragments[0],
                    mFragments[1],
                    mFragments[2],
                    mFragments[3]);
        } else {
            mFragments[0] = findFragment(TestFragment.class);
            mFragments[1] = findFragment(TestFragment.class);
            mFragments[2] = findFragment(TestFragment.class);
            mFragments[3] = findFragment(TestFragment.class);
        }

        mBottomBar.addItem(new BottomBarTab(this, R.mipmap.ic_launcher, "第一"))
                .addItem(new BottomBarTab(this, R.mipmap.ic_launcher, "第二"))
                .addItem(new BottomBarTab(this, R.mipmap.ic_launcher, "第三"))
                .addItem(new BottomBarTab(this, R.mipmap.ic_launcher, "第四"));
        mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                getSupportDelegate().showHideFragment(mFragments[position], mFragments[prePosition]);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void onRetry() {

    }
    @Override
    public boolean isSupportSwipeBack() {
        return false;
    }
}
