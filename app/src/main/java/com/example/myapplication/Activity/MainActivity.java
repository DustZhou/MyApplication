package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {
    private Button butWebPost;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butWebPost = (Button) findViewById(R.id.btn_webpost);
        /**
         * 网络在线库存显示
         * GoodsActivity
         */
        butWebPost.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GoodsActivity.class);
                startActivity(intent);
            }
        });
    }
}