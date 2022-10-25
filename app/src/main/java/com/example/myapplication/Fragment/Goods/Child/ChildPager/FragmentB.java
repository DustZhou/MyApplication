package com.example.myapplication.Fragment.Goods.Child.ChildPager;

import static com.example.myapplication.Dao.DaoPType.GetPriceType;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.FragBAdapter;
import com.example.myapplication.Entity.AddPTypeInfo.PriceType;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import me.yokeyword.fragmentation.SupportFragment;

public class FragmentB extends SupportFragment {
    private static final String ARG_TYPE = "arg_type";
    RecyclerView mRecyclerView;
    List<PriceType> mPriceType = new ArrayList<>();
    FragBAdapter mAdapter;
    private String mTitle;

    public static FragmentB newInstance() {
        Bundle args = new Bundle();
        FragmentB fragment = new FragmentB();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mPriceType = GetPriceType();
        mAdapter = new FragBAdapter(mPriceType);
        LinearLayoutManager layoutManager = new LinearLayoutManager(_mActivity);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(layoutManager);


    }
}
