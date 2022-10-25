package com.example.myapplication.Fragment.Goods.Child.ChildPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.myapplication.R;

import me.yokeyword.fragmentation.SupportFragment;

public class FragmentA extends SupportFragment {
    public static FragmentA newInstance() {
        Bundle args = new Bundle();
        FragmentA fragment = new FragmentA();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        return view;
    }
}
