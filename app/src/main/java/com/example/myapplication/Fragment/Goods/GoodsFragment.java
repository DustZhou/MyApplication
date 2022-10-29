package com.example.myapplication.Fragment.Goods;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.Base.BaseMainFragment;
import com.example.myapplication.Fragment.Goods.Child.ViewPagerFragment;
import com.example.myapplication.R;
/**
 *
 * @ProjectName: GoodsFragment
 * @Package: com.example.myapplication.Fragment.Goods
 * @Description: java类作用描述
 * @Author: ZHT
 * @CreateDate: 2022/10/29
 */

public class GoodsFragment extends BaseMainFragment {
    public static GoodsFragment newInstance(){
        Bundle bundle  = new Bundle();
        GoodsFragment goodsFragment = new GoodsFragment();
        goodsFragment.setArguments(bundle);
        return goodsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_goods,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (findChildFragment(ViewPagerFragment.class) == null){
            loadRootFragment(R.id.frag_goods,ViewPagerFragment.newInstance());
        }
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
    }
}
