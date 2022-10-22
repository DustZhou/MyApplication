package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class QueryActivity extends AppCompatActivity {
    private Button btnQuery;
    private TextView goodsnameTv;
    private String GoodsPTyeID;
    private String GoodsName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        btnQuery = findViewById(R.id.btn_query1);
        goodsnameTv = findViewById(R.id.goods_name);

        btnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(QueryActivity.this,GoodsActivity.class);
            intent.putExtra("GoodsPTyeID",GoodsPTyeID);
            startActivity(intent);
            finish();
            }
        });

        goodsnameTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(QueryActivity.this,GetStockActivity.class);
                startActivityForResult(intent,1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    GoodsName = data.getStringExtra("GoodsName");
                    GoodsPTyeID = data.getStringExtra("GoodsPTyeID");
                    goodsnameTv.setText(GoodsName);
                }
                break;
        }

    }
}
