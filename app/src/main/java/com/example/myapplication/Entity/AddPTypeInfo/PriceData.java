package com.example.myapplication.Entity.AddPTypeInfo;

import androidx.lifecycle.ViewModel;
/**
 *
 * @ProjectName: PriceData
 * @Package: com.example.myapplication.Entity.AddPTypeInfo
 * @Description: java类作用描述
 * @Author: ZHT
 * @CreateDate: 2022/10/29
 */

public class PriceData {
    private String PriceType;

    private String PriceValue;

    public PriceData() {

    }

    public PriceData(String priceType, String priceValue) {
        PriceType = priceType;
        PriceValue = priceValue;
    }

    public void setPriceType(String PriceType) {
        this.PriceType = PriceType;
    }

    public String getPriceType() {
        return this.PriceType;
    }

    public void setPriceValue(String PriceValue) {
        this.PriceValue = PriceValue;
    }

    public String getPriceValue() {
        return this.PriceValue;
    }

    @Override
    public String toString() {
        return "PriceData{" +
                "PriceType='" + PriceType + '\'' +
                ", PriceValue='" + PriceValue + '\'' +
                '}';
    }
}
