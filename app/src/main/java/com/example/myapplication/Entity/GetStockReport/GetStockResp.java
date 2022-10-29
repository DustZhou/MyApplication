package com.example.myapplication.Entity.GetStockReport;

import java.util.List;
/**
 *
 * @ProjectName: GetStockResp
 * @Package: com.example.myapplication.Entity.GetStockReport
 * @Description: java类作用描述
 * @Author: ZHT
 * @CreateDate: 2022/10/29
 */

public class GetStockResp{
    public List<Root> ResData;

    public List<Root> getResData() {
        return ResData;
    }
    public void setResData(List<Root> resData) {
        ResData = resData;
    }
}