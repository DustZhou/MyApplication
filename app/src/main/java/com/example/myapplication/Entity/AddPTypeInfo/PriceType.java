package com.example.myapplication.Entity.AddPTypeInfo;
/**
 *
 * @ProjectName: PriceType
 * @Package: com.example.myapplication.Entity.AddPTypeInfo
 * @Description: java类作用描述
 * @Author: ZHT
 * @CreateDate: 2022/10/29
 */

public class PriceType {
    private String PriceTypeID;
    private String PriceType;
    private String PriceName;
    private String SaleOrBuy;
    private String FullName;

    public PriceType(String PriceTypeID, String PriceType, String PriceName, String SaleOrBuy, String FullName) {
        this.PriceTypeID = PriceTypeID;
        this.PriceType = PriceType;
        this.PriceName = PriceName;
        this.SaleOrBuy = SaleOrBuy;
        this.FullName = FullName;
    }

    @Override
    public String toString() {
        return "PriceType{" +
                "PriceTypeID='" + PriceTypeID + '\'' +
                ", PriceType='" + PriceType + '\'' +
                ", PriceName='" + PriceName + '\'' +
                ", SaleOrBuy='" + SaleOrBuy + '\'' +
                ", FullName='" + FullName + '\'' +
                '}';
    }

    public String getPriceTypeID() {
        return PriceTypeID;
    }

    public void setPriceTypeID(String priceTypeID) {
        PriceTypeID = priceTypeID;
    }

    public String getPriceType() {
        return PriceType;
    }

    public void setPriceType(String priceType) {
        PriceType = priceType;
    }

    public String getPriceName() {
        return PriceName;
    }

    public void setPriceName(String priceName) {
        PriceName = priceName;
    }

    public String getSaleOrBuy() {
        return SaleOrBuy;
    }

    public void setSaleOrBuy(String saleOrBuy) {
        SaleOrBuy = saleOrBuy;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }
}
