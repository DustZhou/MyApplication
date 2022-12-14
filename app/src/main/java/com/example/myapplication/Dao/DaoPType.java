package com.example.myapplication.Dao;

import com.example.myapplication.Entity.AddPTypeInfo.PriceType;
import com.example.myapplication.Entity.AddPTypeInfo.UnitList;
import com.example.myapplication.Entity.AddPTypeInfo.Units;
import com.example.myapplication.Entity.GetStockReport.PType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import db.AppDataDBHelper;
/**
 *
 * @ProjectName: DaoPType
 * @Package: com.example.myapplication.Dao
 * @Description: java类作用描述
 * @Author: ZHT
 * @CreateDate: 2022/10/29
 */

public class DaoPType {

    public static List<PType> GetList(String str){

        List<PType> mPTypeList = new ArrayList<>();
        List<HashMap> res = AppDataDBHelper.getInstance().queryListMap("SELECT * FROM PType WHERE ParID = "+"'"+str+"'");

        for (int i = 0; i < res.size(); i++) {

            PType pType = new PType((String) res.get(i).get("TypeID_"),
                    (String) res.get(i).get("ParID"), (String) res.get(i).get("Leveal"),
                    (String) res.get(i).get("Sonnum"),(String)res.get(i).get("UserCode"),
                    (String)res.get(i).get("FullName"));
            mPTypeList.add(pType);

        }

        return mPTypeList;

    }
    public static List<PType> GetListUp(String str){

        List<PType> mPTypeList = new ArrayList<>();
        List<HashMap> res = AppDataDBHelper.getInstance().queryListMap("SELECT * FROM PType WHERE TypeID_ = "+"'"+str+"'");

        for (int i = 0; i < res.size(); i++) {

            PType pType = new PType((String) res.get(i).get("TypeID_"),
                    (String) res.get(i).get("ParID"), (String) res.get(i).get("Leveal"),
                    (String) res.get(i).get("Sonnum"),(String)res.get(i).get("UserCode"),
                    (String)res.get(i).get("FullName"));
            mPTypeList.add(pType);

        }

        return mPTypeList;
    }

    public static List<PriceType> GetPriceType(){
        List<PriceType> mPriceType = new ArrayList<>();
        List<HashMap> res = AppDataDBHelper.getInstance().queryListMap("SELECT * FROM PriceType WHERE  isDiscount='0'");
        for (int i = 0; i < res.size(); i++) {
            PriceType priceType = new PriceType((String)res.get(i).get("PriceTypeID"),
                    (String)res.get(i).get("PriceType"),
                    (String)res.get(i).get("PriceName"),
                    (String)res.get(i).get("SaleOrBuy"),
                    (String)res.get(i).get("FullName"));
            mPriceType.add(priceType);
        }
        return mPriceType;
    }

    public static List<Units> GetUnits() {
        List<Units> mUnits = new ArrayList<>();
        List<HashMap> res = AppDataDBHelper.getInstance().queryListMap("SELECT * FROM UnitS WHERE  tag='0'");
        for (int i = 0; i < res.size(); i++) {
            Units units = new Units((String)res.get(i).get("UnitID_"), (String) res.get(i).get("FullName"));
            mUnits.add(units);
        }
        return mUnits;
    }

}
