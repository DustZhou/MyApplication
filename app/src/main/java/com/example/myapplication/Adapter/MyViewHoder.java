package com.example.myapplication.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class MyViewHoder extends RecyclerView.ViewHolder {
    TextView mTitleTv;
    TextView mTitleTv2;
    ConstraintLayout mRootView;

    public MyViewHoder(@NonNull View itemView) {
        super(itemView);
        mTitleTv = itemView.findViewById(R.id.tv_Title);
        mTitleTv2 = itemView.findViewById(R.id.tv_Title2);
        mRootView = itemView.findViewById(R.id.rootview);
    }
}
