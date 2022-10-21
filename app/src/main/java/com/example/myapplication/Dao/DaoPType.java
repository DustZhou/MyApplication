package com.example.myapplication.Dao;

import com.example.myapplication.Entity.PType;
import com.example.myapplication.Entity.Root;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import db.AppDataDBHelper;

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
//    public static List<Root> GetRoot(String str){
//        List<Root> mRoot = new ArrayList<>();
//
//
//
//    }

}
