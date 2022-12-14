package com.example.myapplication.Entity.AddPTypeInfo;
import java.util.List;
/**
 *
 * @ProjectName: UnitList
 * @Package: com.example.myapplication.Entity.AddPTypeInfo
 * @Description: java类作用描述
 * @Author: ZHT
 * @CreateDate: 2022/10/29
 */

public class UnitList {
    private List<String> BarCodeData;

    private String BaseUnit;

    private List<PriceData> PriceData;

    private String UnitID;

    private String UnitName;

    private String UnitNum;

    private String UnitRate;

    public UnitList() {
    }

    public UnitList(List<String> BarCodeData, String BaseUnit, List<PriceData> PriceData,
                    String UnitID, String UnitName, String UnitNum, String UnitRate) {
        this.BarCodeData = BarCodeData;
        this.BaseUnit = BaseUnit;
        this.PriceData = PriceData;
        this.UnitID = UnitID;
        this.UnitName = UnitName;
        this.UnitNum = UnitNum;
        this.UnitRate = UnitRate;
    }
    public void setBarCodeData(List<String> BarCodeData) {
        this.BarCodeData = BarCodeData;
    }

    public List<String> getBarCodeData() {
        return this.BarCodeData;
    }

    public void setBaseUnit(String BaseUnit) {
        this.BaseUnit = BaseUnit;
    }

    public String getBaseUnit() {
        return this.BaseUnit;
    }

    public void setPriceData(List<PriceData> PriceData) {
        this.PriceData = PriceData;
    }

    public List<PriceData> getPriceData() {
        return this.PriceData;
    }

    public void setUnitID(String UnitID) {
        this.UnitID = UnitID;
    }

    public String getUnitID() {
        return this.UnitID;
    }

    public void setUnitName(String UnitName) {
        this.UnitName = UnitName;
    }

    public String getUnitName() {
        return this.UnitName;
    }

    public void setUnitNum(String UnitNum) {
        this.UnitNum = UnitNum;
    }

    public String getUnitNum() {
        return this.UnitNum;
    }

    public void setUnitRate(String UnitRate) {
        this.UnitRate = UnitRate;
    }

    public String getUnitRate() {
        return this.UnitRate;
    }

    @Override
    public String toString() {
        return "UnitList{" +
                "BarCodeData=" + BarCodeData +
                ", BaseUnit='" + BaseUnit + '\'' +
                ", PriceData=" + PriceData +
                ", UnitID='" + UnitID + '\'' +
                ", UnitName='" + UnitName + '\'' +
                ", UnitNum='" + UnitNum + '\'' +
                ", UnitRate='" + UnitRate + '\'' +
                '}';
    }
}
