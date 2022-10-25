package com.example.myapplication.Utils;

import com.example.myapplication.Entity.GetStockReport.BodyList;
import com.example.myapplication.Entity.GetStockReport.GetStockResp;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class GsonUtils {
    public static List GetStockList(String str) {
        List<BodyList> mBodyList = new ArrayList<>();

        Gson gson = new Gson();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
            GetStockResp getStockResp = gson.fromJson(str, GetStockResp.class);
            mBodyList.addAll(getStockResp.ResData.get(0).getBodyList());
        }
        return mBodyList;
    }
    public static String GetJson(Object obj){
        Gson gson = new Gson();
        String paramsjson = gson.toJson(obj);
        return paramsjson;
    }
}
