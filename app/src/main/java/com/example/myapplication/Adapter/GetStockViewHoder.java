package com.example.myapplication.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
/**
 *
 * @ProjectName: GetStockViewHoder
 * @Package: com.example.myapplication.Adapter
 * @Description: java类作用描述
 * @Author: ZHT
 * @CreateDate: 2022/10/29
 */

public class GetStockViewHoder extends RecyclerView.ViewHolder {
    TextView mTitleTv;
    TextView mTitleTv2;
    ConstraintLayout mRootView;

    public GetStockViewHoder(@NonNull View itemView) {
        super(itemView);
        mTitleTv = itemView.findViewById(R.id.tv_Title);
        mTitleTv2 = itemView.findViewById(R.id.tv_Title2);
        mRootView = itemView.findViewById(R.id.rootview);
    }
}
