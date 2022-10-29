package com.example.myapplication.ViewModel;

import androidx.lifecycle.ViewModel;

import com.example.myapplication.Entity.AddPTypeInfo.PriceData;
import com.example.myapplication.Entity.AddPTypeInfo.Root;
import com.example.myapplication.Entity.AddPTypeInfo.UnitList;
import com.example.myapplication.Entity.AddPTypeInfo.Units;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 *
 * @ProjectName: AddGoodsModel
 * @Package: com.example.myapplication.ViewModel
 * @Description: java类作用描述
 * @Author: ZHT
 * @CreateDate: 2022/10/29
 */

public class AddGoodsModel extends ViewModel {
    /*
    FragA 用的
     */
    public Root root = new Root();
    //价格
    public HashMap<String,HashMap<String,String>> mUnitListPriceMap = new HashMap<String,HashMap<String,String>>();
    public String str;
    public List<String> stringList = new ArrayList<>();
    //单位
    public HashMap<String,Units> UnitsMap = new HashMap<String,Units>();
    /*

     */
    public List<Units> SpinnerList = new ArrayList<>();




    public List<UnitList> UnitLists = new ArrayList<>();
    public List<PriceData> PriceDatas = new ArrayList<>();

    public List<UnitList> getUnitLists() {
        return UnitLists;
    }

    public void setUnitLists(List<UnitList> unitLists) {
        UnitLists = unitLists;
    }

    public List<PriceData> getPriceDatas() {
        return PriceDatas;
    }

    public void setPriceDatas(List<PriceData> priceDatas) {
        PriceDatas = priceDatas;
    }
}
