package com.example.myapplication.Adapter;

import android.widget.Switch;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapplication.Fragment.Goods.Child.ChildPager.FragmentA;
import com.example.myapplication.Fragment.Goods.Child.ChildPager.FragmentB;
import com.example.myapplication.Fragment.Goods.Child.ChildPager.FragmentC;

/**
 *
 * @ProjectName: GoodsFragmentAdapter
 * @Package: com.example.myapplication.Adapter
 * @Description: java类作用描述
 * @Author: ZHT
 * @CreateDate: 2022/10/29
 */

public class GoodsFragmentAdapter extends FragmentPagerAdapter {
    private String[] mTitles;

    public GoodsFragmentAdapter(FragmentManager fm, String... titles) {
        super(fm);
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return FragmentA.newInstance();
            case 1:
                return FragmentB.newInstance();
            case 2:
                return FragmentC.newInstance();
            default:
                break;
        }
        return null;
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
