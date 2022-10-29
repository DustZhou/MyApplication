package com.example.myapplication.Activity;

import static com.example.myapplication.Dao.DaoPType.GetList;
import static com.example.myapplication.Dao.DaoPType.GetListUp;
import static com.example.myapplication.Utils.FileUtils.CopyFile;

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
import com.example.myapplication.Adapter.GetStockAdapter;
import com.example.myapplication.Entity.GetStockReport.PType;
import com.example.myapplication.R;
import com.example.myapplication.Utils.FileUtils;

import db.AppDataDBHelper;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @ProjectName: GetStockActivity
 * @Package: com.example.myapplication.Activity
 * @Description: java类作用描述
 * @Author: ZHT
 * @CreateDate: 2022/10/29
 */

public class GetStockActivity extends AppCompatActivity {
    private Button butUponelevel;
    private Context context;
    RecyclerView mRecyclerView;
    GetStockAdapter myAdapter;
    List<PType> mPTypeList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_getstock);
        mRecyclerView = findViewById(R.id.recyclerView);
        butUponelevel = findViewById(R.id.btn_Uponelevel);
        /*
        文件处理 copyStreamtoFile
         */
        File  appdatadb =new File(getCacheDir().getAbsolutePath()+"db");
        CopyFile(appdatadb);
//        if (!appdatadb.exists()) { // 判断是否存在，不存在则从安装目录中复制
//            InputStream inStream = APP.getInstance().getResources().openRawResource(R.raw.tmp);
//            FileUtils.copyStreamtoFile(inStream, appdatadb.toString());
//        }
//        //APPDATA设置DB路径
//        AppDataDBHelper.InitDBNAME(appdatadb.getAbsolutePath());
        mPTypeList.addAll(GetList("00000"));
        myAdapter = new GetStockAdapter(context,mPTypeList);
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
