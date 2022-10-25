package com.example.myapplication.Activity;

import static com.example.myapplication.Utils.FileUtils.CopyFile;

import android.os.Bundle;

import com.example.myapplication.Fragment.Goods.GoodsFragment;
import com.example.myapplication.R;

import java.io.File;

import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.SupportFragment;

public class AddGoodsActivity extends SupportActivity {
    private SupportFragment mFragment = new SupportFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actiivity_addgoods);
        File appdatadb =new File(getCacheDir().getAbsolutePath()+"db");
        CopyFile(appdatadb);
        SupportFragment firstFragment = findFragment(GoodsFragment.class);
        if (firstFragment == null) {
            mFragment = GoodsFragment.newInstance();
            loadRootFragment(R.id.fl_container,mFragment);
        } else {
            mFragment = firstFragment;
        }


    }
}
