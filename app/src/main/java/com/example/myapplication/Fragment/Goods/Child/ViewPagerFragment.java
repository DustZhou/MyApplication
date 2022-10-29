package com.example.myapplication.Fragment.Goods.Child;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.Adapter.GoodsFragmentAdapter;
import com.example.myapplication.R;
import com.google.android.material.tabs.TabLayout;

import me.yokeyword.fragmentation.SupportFragment;
/**
 *
 * @ProjectName: ViewPagerFragment
 * @Package: com.example.myapplication.Fragment.Goods.Child
 * @Description: java类作用描述
 * @Author: ZHT
 * @CreateDate: 2022/10/29
 */

public class ViewPagerFragment extends SupportFragment {
    private TabLayout mTab;
    private ViewPager mViewPager;
    public static ViewPagerFragment newInstance() {

        Bundle args = new Bundle();

        ViewPagerFragment fragment = new ViewPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_goods_pager, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mTab = (TabLayout) view.findViewById(R.id.tab);
        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);

        mTab.addTab(mTab.newTab());
        mTab.addTab(mTab.newTab());

        mViewPager.setAdapter(new GoodsFragmentAdapter(getChildFragmentManager(),
                getString(R.string.recommend), getString(R.string.hot), getString(R.string.favorite)));
        mTab.setupWithViewPager(mViewPager);

    }
}
