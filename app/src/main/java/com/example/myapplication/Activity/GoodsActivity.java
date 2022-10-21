package com.example.myapplication.Activity;

import static com.example.myapplication.Dao.DaoPType.GetList;
import static com.example.myapplication.Dao.DaoPType.GetListUp;
import static com.example.myapplication.Utils.GsonUtils.GetStockList;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Entity.BodyList;
import com.example.myapplication.Entity.GetStockRequest;
import com.example.myapplication.Entity.PType;
import com.example.myapplication.R;
import com.example.myapplication.Service.Webservice;
import com.example.myapplication.Utils.GsonUtils;

import java.util.ArrayList;
import java.util.List;

public class GoodsActivity extends AppCompatActivity {
    private String URL = "http://ys.wltrj.com:80/wlt/AndroidWebSevice.asmx";
    private String methodName = "GetStockReport";
    private Button butUp;

    RecyclerView mGoodsView;
    GoodsAdapter mGoodsAdapter;
    List<BodyList> mPtypeList = new ArrayList<>();
    GetStockRequest getStockRequest = new GetStockRequest();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
        butUp = findViewById(R.id.btn_Up);
        /*
        将对象转化为JSON
        调GsonUtils.GetJson();
         */
           Bundle params = new Bundle();
        params.putString("WoolinteValue", GsonUtils.GetJson(getStockRequest));
        new Thread(){
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
        mGoodsAdapter = new GoodsAdapter();
        mGoodsView.setAdapter(mGoodsAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(GoodsActivity.this);
        mGoodsView.setLayoutManager(layoutManager);

        butUp.setOnClickListener(new View.OnClickListener() {
             @SuppressLint("NotifyDataSetChanged")
             @Override
             public void onClick(View view) {
                 //


                 //5
                 if (mPtypeList.size() != 0&&mPtypeList.get(0).getParID_().equals("00000")){
                     Toast.makeText(GoodsActivity.this,"没有上一级",Toast.LENGTH_LONG).show();
                     return;
                 }
                 String mPariD = "";
                 if (mPtypeList.size() == 0){
                     mPariD = "";
                 }else {
                     BodyList bodyList = mPtypeList.get(0);
                     if (bodyList.getPTypeID_().length()<10){
                         mPariD = "";
                     }else {
                         mPariD = bodyList.getPTypeID_().substring(0,bodyList.getPTypeID_().length()-10);
                     }
                 }
                 getStockRequest.PTypeID_ = mPariD;
                     Bundle params = new Bundle();
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
}
    /**
     * GoodsAdapter
     * 对recycleview处理
     *
     */
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
            BodyList bodyList = mPtypeList.get(position);
            holder.mTitleTv.setText(bodyList.getPTypeName());
            holder.mTitleTv2.setText(bodyList.getPTypeID_());
            holder.mRootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getStockRequest.PTypeID_=bodyList.getPTypeID_();
                    Bundle params = new Bundle();
                    params.putString("WoolinteValue", GsonUtils.GetJson(getStockRequest));
                    new Thread(){
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
        }

        @Override
        public int getItemCount() {
            return mPtypeList.size();
        }
    }
    /**
     * GoodsViewHoder
     * 设置item
     */
    class GoodsViewHoder extends RecyclerView.ViewHolder{
        TextView mTitleTv;
        TextView mTitleTv2;
        ConstraintLayout mRootView;
        public GoodsViewHoder(@NonNull View itemView) {
            super(itemView);
            mTitleTv = itemView.findViewById(R.id.tv_Title);
            mTitleTv2 = itemView.findViewById(R.id.tv_Title2);
            mRootView = itemView.findViewById(R.id.rootview);
        }
    }
}
