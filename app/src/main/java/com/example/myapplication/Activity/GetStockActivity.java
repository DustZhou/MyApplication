package com.example.myapplication.Activity;

import static com.example.myapplication.Dao.DaoPType.GetList;
import static com.example.myapplication.Dao.DaoPType.GetListUp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.APP;
import com.example.myapplication.Adapter.MyAdapter;
import com.example.myapplication.Entity.PType;
import com.example.myapplication.R;
import com.example.myapplication.Utils;

import db.AppDataDBHelper;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class GetStockActivity extends AppCompatActivity {
    private Button butUponelevel;
    private Context context;
    RecyclerView mRecyclerView;
    MyAdapter myAdapter;
    List<PType> mPTypeList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_getstock);
        mRecyclerView = findViewById(R.id.recyclerView);
        butUponelevel = findViewById(R.id.btn_Uponelevel);
        File  appdatadb =new File(getCacheDir().getAbsolutePath()+"db");
        if (!appdatadb.exists()) { // 判断是否存在，不存在则从安装目录中复制
            InputStream inStream = APP.getInstance().getResources().openRawResource(R.raw.tmp);
            Utils.copyStreamtoFile(inStream, appdatadb.toString());
        }
        //APPDATA设置DB路径
        AppDataDBHelper.InitDBNAME(appdatadb.getAbsolutePath());
        mPTypeList = GetList("00000");
        myAdapter = new MyAdapter(context,mPTypeList);
        mRecyclerView.setAdapter(myAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(GetStockActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);

        butUponelevel.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                PType type = mPTypeList.get(0);
                if (!type.getParID().equals("00000")){
                    mPTypeList.clear();
                    mPTypeList.addAll(GetListUp(type.getParID()));
                    PType ptype = mPTypeList.get(0);
                    mPTypeList.clear();
                    mPTypeList.addAll(GetList(ptype.getParID()));
                    myAdapter.notifyDataSetChanged();
                }else {
                }
            }
        });
    }
}