package com.leostones.applicationmarket.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.leostones.applicationmarket.R;
import com.leostones.applicationmarket.ui.fragment.BaseFragment;
import com.leostones.applicationmarket.ui.fragment.FragmentFactroy;
import com.leostones.applicationmarket.ui.view.PagerTab;
import com.leostones.applicationmarket.utils.UIUtils;


public class MainActivity extends BaseActivity {

    private ViewPager mViewPager;
    private PagerTab mPagerTab;
    private MyAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPagerTab = (PagerTab) findViewById(R.id.pager_tab);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mAdapter = new MyAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);

        mPagerTab.setViewPager(mViewPager);//将指针和viewpager绑定到一起
        mPagerTab.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                BaseFragment fragment = FragmentFactroy.createFragment(position);
                fragment.loadData();
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
    /**
     * FragmentPagerAdapter是PagerAdapter的子类, 如果viewpager的页面是fragment的话,就继承此类
     */
    class MyAdapter extends FragmentPagerAdapter {
        private String[] mTabNames;

        public MyAdapter(FragmentManager fm) {
            super(fm);
            mTabNames = UIUtils.getStringArray(R.array.tab_names);//获取标签名字
        }

        //返回页面标签
        @Override
        public CharSequence getPageTitle(int position) {
            return mTabNames[position];
        }

        //返回当前页面位置的fragment对象
        @Override
        public Fragment getItem(int position) {
            BaseFragment fragment = FragmentFactroy.createFragment(position);
            return fragment;
        }

        //fragment的数量
        @Override
        public int getCount() {
            return mTabNames.length;
        }
    }

}
