package com.example.myapplication.Activity;

import android.os.Bundle;

import com.example.myapplication.Fragment.Goods.GoodsFragment;
import com.example.myapplication.R;

import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.SupportFragment;

public class AddGoodsActivity extends SupportActivity {
    private SupportFragment mFragment = new SupportFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actiivity_addgoods);
        SupportFragment firstFragment = findFragment(GoodsFragment.class);
        if (firstFragment == null) {
            mFragment = GoodsFragment.newInstance();
            loadRootFragment(R.id.fl_container,mFragment);
        } else {
            mFragment = firstFragment;
        }


    }
}
