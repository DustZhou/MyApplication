package com.example.myapplication.Adapter;

import static com.example.myapplication.Utils.GsonUtils.GetStockList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Entity.GetStockReport.BodyList;
import com.example.myapplication.Entity.GetStockReport.GetStockRequest;
import com.example.myapplication.R;
import com.example.myapplication.Service.Webservice;
import com.example.myapplication.Utils.GsonUtils;

import java.util.List;

/**
 *
 * @ProjectName: GoodsAdapter
 * @Package: com.example.myapplication.Adapter
 * @Description: java类作用描述
 * @Author: ZHT
 * @CreateDate: 2022/10/29
 */

public class GoodsAdapter extends RecyclerView.Adapter<GoodsViewHoder> {
    //网络请求的地址Url 和 接口名字
    private String URL = "http://ys.wltrj.com:80/wlt/AndroidWebSevice.asmx";
    private String methodName = "GetStockReport";
    private Context context;
    private List<BodyList> mPtypeList;
    GetStockRequest getStockRequest = new GetStockRequest();

    public GoodsAdapter(Context context, List<BodyList> mPtypeList) {
        this.context = context;
        this.mPtypeList = mPtypeList;
    }

    @NonNull
    @Override
    public GoodsViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        GoodsViewHoder myViewHoder = new GoodsViewHoder(view);
        return myViewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull GoodsViewHoder holder, int position) {
        BodyList bodyList = mPtypeList.get(position);
        holder.mTitleTv.setText(bodyList.getPTypeName());
        holder.mTitleTv2.setText(bodyList.getPTypeID_());
        if (!bodyList.getSUnitQty().equals("")) {
            holder.mTitleTv3.setText(bodyList.getSUnitQty());
        }
        holder.mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getStockRequest.PTypeID_ = bodyList.getPTypeID_();
                Bundle params = new Bundle();
                params.putString("WoolinteValue", GsonUtils.GetJson(getStockRequest));
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        mPtypeList.clear();
                        mPtypeList.addAll(GetStockList(Webservice.callWebService(URL, methodName, params, 5000)));
                        ((Activity)context).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                notifyDataSetChanged();
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