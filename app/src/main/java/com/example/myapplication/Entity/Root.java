package com.example.myapplication.Entity;

import java.util.List;

public class Root {
    private List<BodyList> BodyList;

    private String SumQty;

    private String SumTotal;

    private String ReferencePriceType;

    private String ReferencePriceName;

    public void setBodyList(List<BodyList> BodyList) {
        this.BodyList = BodyList;
    }

    public List<BodyList> getBodyList() {
        return this.BodyList;
    }

    public void setSumQty(String SumQty) {
        this.SumQty = SumQty;
    }

    public String getSumQty() {
        return this.SumQty;
    }

    public void setSumTotal(String SumTotal) {
        this.SumTotal = SumTotal;
    }

    public String getSumTotal() {
        return this.SumTotal;
    }

    public void setReferencePriceType(String ReferencePriceType) {
        this.ReferencePriceType = ReferencePriceType;
    }

    public String getReferencePriceType() {
        return this.ReferencePriceType;
    }

    public void setReferencePriceName(String ReferencePriceName) {
        this.ReferencePriceName = ReferencePriceName;
    }

    public String getReferencePriceName() {
        return this.ReferencePriceName;
    }
}
