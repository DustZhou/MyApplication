package com.example.myapplication.Base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
/**
 *
 * @ProjectName: BaseActivity
 * @Package: com.example.myapplication.Base
 * @Description: java类作用描述
 * @Author: ZHT
 * @CreateDate: 2022/10/29
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.actiivity_base);
        super.onCreate(savedInstanceState);
    }
}
