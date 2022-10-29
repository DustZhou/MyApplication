package com.example.myapplication.Fragment.Goods.Child.ChildPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;

import me.yokeyword.fragmentation.SupportFragment;
/**
 *
 * @ProjectName: FragmentC
 * @Package: com.example.myapplication.Fragment.Goods.Child.ChildPager
 * @Description: java类作用描述
 * @Author: ZHT
 * @CreateDate: 2022/10/29
 */

public class FragmentC extends SupportFragment {

    public static FragmentC newInstance() {

        Bundle args = new Bundle();
        FragmentC fragment = new FragmentC();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c,container,false);
        return view;
    }

}
