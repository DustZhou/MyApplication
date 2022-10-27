package com.example.myapplication.Entity.AddPTypeInfo;

public class Units {
    private String UnitID;
    private String FullName;

    public Units() {

    }

    public Units(String UnitID_, String FullName) {
        this.UnitID = UnitID_;
        this.FullName = FullName;
    }

    @Override
    public String toString() {
        return "Units{" +
                "UnitID='" + UnitID + '\'' +
                ", FullName='" + FullName + '\'' +
                '}';
    }

    public String getUnitID() {
        return UnitID;
    }

    public void setUnitID(String unitID) {
        UnitID = unitID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }
}
