package com.example.myapplication.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Entity.GetStockReport;
import com.example.myapplication.Entity.PType;
import com.example.myapplication.R;
import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import db.AppDataDBHelper;

public class GoodsActivity extends AppCompatActivity {
    RecyclerView mGoodsView;
    GoodsAdapter mGoodsAdapter;
    List<PType> mPTypeList =new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);

        GetStockReport obj = new GetStockReport();
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        Log.e("11","22"+json);



        mGoodsView = findViewById(R.id.goodsView);
        mGoodsAdapter = new GoodsAdapter();
        mGoodsView.setAdapter(mGoodsAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(GoodsActivity.this);
        mGoodsView.setLayoutManager(layoutManager);
    }
    class GoodsAdapter extends RecyclerView.Adapter<GoodsViewHoder>{

        @NonNull
        @Override
        public GoodsViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = View.inflate(GoodsActivity.this, R.layout.item_list, null);
            GoodsActivity.GoodsViewHoder myViewHoder = new GoodsActivity.GoodsViewHoder(view);
            return myViewHoder;
        }

        @Override
        public void onBindViewHolder(@NonNull GoodsViewHoder holder, int position) {
            PType type = mPTypeList.get(position);
            holder.mTitleTv.setText(type.getFullName());
        }

        @Override
        public int getItemCount() {
            return mPTypeList.size();
        }
    }
    class GoodsViewHoder extends RecyclerView.ViewHolder{
        TextView mTitleTv;
        public GoodsViewHoder(@NonNull View itemView) {
            super(itemView);
            mTitleTv = itemView.findViewById(R.id.tv_Title);
        }
    }
}
