package com.example.myapplication;

import android.app.Application;

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
