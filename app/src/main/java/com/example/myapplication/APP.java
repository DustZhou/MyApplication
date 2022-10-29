package com.example.myapplication;

import android.app.Application;
/**
 *
 * @ProjectName: APP
 * @Package: com.example.myapplication
 * @Description: java类作用描述
 * @Author: ZHT
 * @CreateDate: 2022/10/29
 */

public class APP extends Application {
    private static APP app;

    public static APP getInstance() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
