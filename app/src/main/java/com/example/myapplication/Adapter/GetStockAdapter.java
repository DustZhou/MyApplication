package com.example.myapplication.Adapter;

import static com.example.myapplication.Dao.DaoPType.GetList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Entity.GetStockReport.PType;
import com.example.myapplication.R;

import java.util.List;
/**
 *
 * @ProjectName: GetStockAdapter
 * @Package: com.example.myapplication.Adapter
 * @Description: java类作用描述
 * @Author: ZHT
 * @CreateDate: 2022/10/29
 */

public class GetStockAdapter extends RecyclerView.Adapter<GetStockViewHoder> {
    private Context context;
    private List<PType> mPTypeList;

    public GetStockAdapter(Context context, List<PType> mPTypeList) {
        this.context = context;
        this.mPTypeList = mPTypeList;
    }

    @NonNull
    @Override
    public GetStockViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        GetStockViewHoder myViewHoder = new GetStockViewHoder(view);
        return myViewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull GetStockViewHoder holder, @SuppressLint("RecyclerView") final int position) {
        PType type = mPTypeList.get(position);
        holder.mTitleTv.setText(type.getFullName());
        holder.mTitleTv2.setText(type.getTypeID());
        holder.mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!type.getSonnum().equals("0")) {
                    mPTypeList.clear();
                    mPTypeList.addAll(GetList(type.getTypeID()));
                    notifyDataSetChanged();
                    Log.e("11", "mse" + type.getTypeID());
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("GoodsName", type.getFullName());
                    intent.putExtra("GoodsPTyeID", type.getTypeID());
                    intent.putExtra("GoodsParID",type.getParID());
                    ((Activity) context).setResult(Activity.RESULT_OK, intent);
                    ((Activity) context).finish();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPTypeList.size();
    }

}


