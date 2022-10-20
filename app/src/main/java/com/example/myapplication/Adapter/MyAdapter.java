package com.example.myapplication.Adapter;

import static com.example.myapplication.Dao.DaoPType.GetList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Entity.PType;
import com.example.myapplication.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHoder> {
    private Context context;
    private List<PType> mPTypeList;
    public MyAdapter(Context context, List<PType> mPTypeList) {
        this.context = context;
        this.mPTypeList = mPTypeList;
    }

    @NonNull
    @Override
    public MyViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list,parent,false);
        MyViewHoder myViewHoder = new MyViewHoder(view);
        return myViewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoder holder, @SuppressLint("RecyclerView") final int position) {
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
                }else {
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPTypeList.size();
    }
}


