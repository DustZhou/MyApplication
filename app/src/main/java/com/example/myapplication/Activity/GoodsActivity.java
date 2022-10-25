package com.example.myapplication.Activity;

import static com.example.myapplication.Utils.GsonUtils.GetStockList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.GoodsAdapter;
import com.example.myapplication.Entity.GetStockReport.BodyList;
import com.example.myapplication.Entity.GetStockReport.GetStockRequest;
import com.example.myapplication.R;
import com.example.myapplication.Service.Webservice;
import com.example.myapplication.Utils.GsonUtils;

import java.util.ArrayList;
import java.util.List;

public class GoodsActivity extends AppCompatActivity {
    //网络请求的地址Url 和 接口名字
    private String URL = "http://ys.wltrj.com:80/wlt/AndroidWebSevice.asmx";
    private String methodName = "GetStockReport";
    private String GoodsPTyeID;

    private Context context;
    private Button butUp;
    private Button butQuery;

    RecyclerView mGoodsView;
    GoodsAdapter mGoodsAdapter;
    List<BodyList> mPtypeList = new ArrayList<>();
    GetStockRequest getStockRequest = new GetStockRequest();

    /**
     * 货物库存Activity onCreate
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_goods);
        butUp = findViewById(R.id.btn_Up);
        butQuery = (Button) findViewById(R.id.btn_query);
        Bundle params = new Bundle();
        /*
        查询界面传值
        将GoodsPTyeID 传给请求实体类
        再调接口返回数据
         */
        Intent intent = getIntent();
        if ((intent.getStringExtra("GoodsPTyeID") != null)) {
            GoodsPTyeID = intent.getStringExtra("GoodsPTyeID");
            getStockRequest.PTypeID_ = GoodsPTyeID;
        }
        /*
        将对象转化为JSON
        调GsonUtils.GetJson();
         */
        params.putString("WoolinteValue", GsonUtils.GetJson(getStockRequest));
        /**
         * 获取json 后 调用接口获取数据
         */
        new Thread() {
            @Override
            public void run() {
                super.run();
                mPtypeList.addAll(GetStockList(Webservice.callWebService(URL, methodName, params, 5000)));
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mGoodsAdapter.notifyDataSetChanged();
                    }
                });
            }
        }.start();
        mGoodsView = findViewById(R.id.goodsView);
        mGoodsAdapter = new GoodsAdapter(context, mPtypeList);
        mGoodsView.setAdapter(mGoodsAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(GoodsActivity.this);
        mGoodsView.setLayoutManager(layoutManager);
        /**
         * 上一级按钮
         * bntUp 点击事件逻辑
         */
        butUp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                if (mPtypeList.size() != 0 && mPtypeList.get(0).getParID_().equals("00000")) {
                    Toast.makeText(GoodsActivity.this, "没有上一级", Toast.LENGTH_LONG).show();
                    return;
                }
                String mPariD = "";
                if (mPtypeList.size() == 0) {
                    mPariD = "";
                } else {
                    BodyList bodyList = mPtypeList.get(0);
                    if (bodyList.getPTypeID_().length() < 10) {
                        mPariD = "";
                    } else {
                        mPariD = bodyList.getPTypeID_().substring(0, bodyList.getPTypeID_().length() - 10);
                    }
                }
                getStockRequest.PTypeID_ = mPariD;
                params.putString("WoolinteValue", GsonUtils.GetJson(getStockRequest));
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        mPtypeList.clear();
                        mPtypeList.addAll(GetStockList(Webservice.callWebService(URL, methodName, params, 5000)));
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mGoodsAdapter.notifyDataSetChanged();
                            }
                        });
                    }
                }.start();
            }
        });
        /**
         * 根据本地获取ID查询在线库存
         * QueryActivity
         */
        butQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GoodsActivity.this, QueryActivity.class);
                startActivity(intent);
            }
        });
    }
}

