//package com.example.myapplication.db;
//
//import android.content.Context;
//
//import com.tencent.wcdb.database.SQLiteDatabase;
//import com.tencent.wcdb.database.SQLiteOpenHelper;
//
//public class DBHelper extends SQLiteOpenHelper {
//    //数据库名
//    private static final String DEFAULT_NAME = "tmp.db";
//    // 默认版本号
//    private static final int DEFAULT_VERSION = 2;
//    private Context context;
//
//
//
//    /**
//     * 通过父类构造方法创建 person 数据库
//     */
//    public DBHelper(Context context) {
//        super(context, DEFAULT_NAME, null, DEFAULT_VERSION, null);
//        this.context = context;
//
//    }
//
//    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
//        this.context = context;
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//
//    }
//}
