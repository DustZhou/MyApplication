package com.example.myapplication.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapplication.Fragment.Goods.Child.ChildPager.FragmentA;
import com.example.myapplication.Fragment.Goods.Child.ChildPager.FragmentB;

/**
 * Created by YoKeyword on 16/6/5.
 */
public class GoodsFragmentAdapter extends FragmentPagerAdapter {
    private String[] mTitles;

    public GoodsFragmentAdapter(FragmentManager fm, String... titles) {
        super(fm);
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return FragmentA.newInstance();
        } else {
            return FragmentB.newInstance(mTitles[position]);
        }
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
