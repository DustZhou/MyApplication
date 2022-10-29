package com.example.myapplication.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

/**
 *
 * @ProjectName: GoodsViewHoder
 * @Package: com.example.myapplication.Adapter
 * @Description: java类作用描述
 * @Author: ZHT
 * @CreateDate: 2022/10/29
 */

public class GoodsViewHoder extends RecyclerView.ViewHolder {
    TextView mTitleTv;
    TextView mTitleTv2;
    TextView mTitleTv3;
    ConstraintLayout mRootView;

    public GoodsViewHoder(@NonNull View itemView) {
        super(itemView);
        mTitleTv = itemView.findViewById(R.id.tv_Title);
        mTitleTv2 = itemView.findViewById(R.id.tv_Title2);
        mTitleTv3 = itemView.findViewById(R.id.tv_Title3);
        mRootView = itemView.findViewById(R.id.rootview);
    }
}
