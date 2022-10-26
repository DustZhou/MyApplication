package com.example.myapplication.ViewModel;

import androidx.lifecycle.ViewModel;

import com.example.myapplication.Entity.AddPTypeInfo.PriceData;
import com.example.myapplication.Entity.AddPTypeInfo.Root;
import com.example.myapplication.Entity.AddPTypeInfo.UnitList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddGoodsModel extends ViewModel {
    public Root root = new Root();
    public HashMap<String,String> priceDataMap = new HashMap<String,String>();
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
