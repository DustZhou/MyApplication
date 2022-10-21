package com.example.myapplication.Utils;

import java.io.FileOutputStream;
import java.io.InputStream;

public class FileUtils {
    /**
     * 文件流复制到文件
     */
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
