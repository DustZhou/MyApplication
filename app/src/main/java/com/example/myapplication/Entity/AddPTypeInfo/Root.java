package com.example.myapplication.Entity.AddPTypeInfo;

import com.example.myapplication.Entity.BaseRequest;

import java.util.List;

public class Root extends BaseRequest{
    private String Area;

    private String BTypeID;

    private List<String> BarCodeList;

    private String BillID;

    private String BrandTypeID;

    private String Comment;

    private String FullName;

    private List<String> ImageList;

    private String NamePy;

    private int PTypeRecID;

    private String ParID;

    private String RowIndex;

    private String Standard;

    private String Type;

    private List<UnitList> UnitList;

    private String UserCode;

    private String UserID;

    public Root(String area, String BTypeID, List<String> barCodeList, String billID, String brandTypeID, String comment, String fullName, List<String> imageList, String namePy, int PTypeRecID, String parID, String rowIndex, String standard, String type, List<UnitList> unitList, String userCode, String userID) {
        Area = area;
        this.BTypeID = BTypeID;
        BarCodeList = barCodeList;
        BillID = billID;
        BrandTypeID = brandTypeID;
        Comment = comment;
        FullName = fullName;
        ImageList = imageList;
        NamePy = namePy;
        this.PTypeRecID = PTypeRecID;
        ParID = parID;
        RowIndex = rowIndex;
        Standard = standard;
        Type = type;
        UnitList = unitList;
        UserCode = userCode;
        UserID = userID;
    }

    public Root() {

    }

    public void setArea(String Area) {
        this.Area = Area;
    }

    public String getArea() {
        return this.Area;
    }

    public void setBTypeID(String BTypeID) {
        this.BTypeID = BTypeID;
    }

    public String getBTypeID() {
        return this.BTypeID;
    }

    public void setBarCodeList(List<String> BarCodeList) {
        this.BarCodeList = BarCodeList;
    }

    public List<String> getBarCodeList() {
        return this.BarCodeList;
    }

    public void setBillID(String BillID) {
        this.BillID = BillID;
    }

    public String getBillID() {
        return this.BillID;
    }

    public void setBrandTypeID(String BrandTypeID) {
        this.BrandTypeID = BrandTypeID;
    }

    public String getBrandTypeID() {
        return this.BrandTypeID;
    }

    public void setCodeWord(String CodeWord) {
        this.CodeWord = CodeWord;
    }

    public String getCodeWord() {
        return this.CodeWord;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public String getComment() {
        return this.Comment;
    }

    public void setConnectionKey(String ConnectionKey) {
        this.ConnectionKey = ConnectionKey;
    }

    public String getConnectionKey() {
        return this.ConnectionKey;
    }

    public void setDbName(String DbName) {
        this.DbName = DbName;
    }

    public String getDbName() {
        return this.DbName;
    }

    public void setEditionName(String EditionName) {
        this.EditionName = EditionName;
    }

    public String getEditionName() {
        return this.EditionName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getFullName() {
        return this.FullName;
    }

    public void setImageList(List<String> ImageList) {
        this.ImageList = ImageList;
    }

    public List<String> getImageList() {
        return this.ImageList;
    }

    public void setLoginID(String LoginID) {
        this.LoginID = LoginID;
    }

    public String getLoginID() {
        return this.LoginID;
    }

    public void setNamePy(String NamePy) {
        this.NamePy = NamePy;
    }

    public String getNamePy() {
        return this.NamePy;
    }

    public void setPTypeRecID(int PTypeRecID) {
        this.PTypeRecID = PTypeRecID;
    }

    public int getPTypeRecID() {
        return this.PTypeRecID;
    }

    public void setParID(String ParID) {
        this.ParID = ParID;
    }

    public String getParID() {
        return this.ParID;
    }

    public void setRowIndex(String RowIndex) {
        this.RowIndex = RowIndex;
    }

    public String getRowIndex() {
        return this.RowIndex;
    }

    public void setStandard(String Standard) {
        this.Standard = Standard;
    }

    public String getStandard() {
        return this.Standard;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getType() {
        return this.Type;
    }

    public void setUnitList(List<UnitList> UnitList) {
        this.UnitList = UnitList;
    }

    public List<UnitList> getUnitList() {
        return this.UnitList;
    }

    public void setUserCode(String UserCode) {
        this.UserCode = UserCode;
    }

    public String getUserCode() {
        return this.UserCode;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getUserID() {
        return this.UserID;
    }

    @Override
    public String toString() {
        return "Root{" +
                "Area='" + Area + '\'' +
                ", BTypeID='" + BTypeID + '\'' +
                ", BarCodeList=" + BarCodeList +
                ", BillID='" + BillID + '\'' +
                ", BrandTypeID='" + BrandTypeID + '\'' +
                ", Comment='" + Comment + '\'' +
                ", FullName='" + FullName + '\'' +
                ", ImageList=" + ImageList +
                ", NamePy='" + NamePy + '\'' +
                ", PTypeRecID=" + PTypeRecID +
                ", ParID='" + ParID + '\'' +
                ", RowIndex='" + RowIndex + '\'' +
                ", Standard='" + Standard + '\'' +
                ", Type='" + Type + '\'' +
                ", UnitList=" + UnitList +
                ", UserCode='" + UserCode + '\'' +
                ", UserID='" + UserID + '\'' +
                '}';
    }
}
