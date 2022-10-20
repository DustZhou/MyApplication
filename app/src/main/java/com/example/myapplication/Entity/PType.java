package com.example.myapplication.Entity;

public class PType {
    private String TypeID;
    private String ParID;
    private String Leveal;
    private String Sonnum;
    private String UserCode;
    private String FullName;

    public PType(){

    }
    public PType(String TypeID_,String ParID,String Leveal,String Sonnum,String UserCode,String FullName){
        this.TypeID= TypeID_;
        this.ParID= ParID;
        this.Leveal= Leveal;
        this.Sonnum= Sonnum;
        this.UserCode= UserCode;
        this.FullName= FullName;
    }


    public String getTypeID() {
        return TypeID;
    }

    public void setTypeID(String typeID) {
        TypeID = typeID;
    }

    public String getParID() {
        return ParID;
    }

    public void setParID(String parID) {
        ParID = parID;
    }

    public String getLeveal() {
        return Leveal;
    }

    public void setLeveal(String leveal) {
        Leveal = leveal;
    }

    public String getSonnum() {
        return Sonnum;
    }

    public void setSonnum(String sonnum) {
        Sonnum = sonnum;
    }

    public String getUserCode() {
        return UserCode;
    }

    public void setUserCode(String userCode) {
        UserCode = userCode;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    @Override
    public String toString() {
        return "PType{" +
                "TypeID='" + TypeID + '\'' +
                ", ParID='" + ParID + '\'' +
                ", Leveal='" + Leveal + '\'' +
                ", Sonnum='" + Sonnum + '\'' +
                ", UserCode='" + UserCode + '\'' +
                ", FullName='" + FullName + '\'' +
                '}';
    }
}
