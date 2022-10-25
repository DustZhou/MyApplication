package com.example.myapplication.Utils;

import com.example.myapplication.APP;
import com.example.myapplication.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import db.AppDataDBHelper;

public class FileUtils {
    /**
     * 文件流复制到文件
     */

    public static void CopyFile(File file){

        if (!file.exists()) { // 判断是否存在，不存在则从安装目录中复制
            InputStream inStream = APP.getInstance().getResources().openRawResource(R.raw.tmp);
            FileUtils.copyStreamtoFile(inStream, file.toString());
        }
        //APPDATA设置DB路径
        AppDataDBHelper.InitDBNAME(file.getAbsolutePath());
    }

    public static void copyStreamtoFile(InputStream inStream, String newPath) {
        try {
            int bytesum = 0;
            int byteread = 0;
            //读入原文件
            FileOutputStream fs = new FileOutputStream(newPath);
            byte[] buffer = new byte[1444];
            while ((byteread = inStream.read(buffer)) != -1) {
                //字节数 文件大小
                bytesum += byteread;
                fs.write(buffer, 0, byteread);
            }
            fs.close();
            inStream.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
