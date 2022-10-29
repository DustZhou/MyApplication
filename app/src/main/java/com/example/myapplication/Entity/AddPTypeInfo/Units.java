package com.example.myapplication.Entity.AddPTypeInfo;
/**
 *
 * @ProjectName: Units
 * @Package: com.example.myapplication.Entity.AddPTypeInfo
 * @Description: java类作用描述
 * @Author: ZHT
 * @CreateDate: 2022/10/29
 */

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
