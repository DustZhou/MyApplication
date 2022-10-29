package com.example.myapplication.Utils;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.myapplication.Adapter.SpinnerAdapter;
import com.example.myapplication.Entity.AddPTypeInfo.Units;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @ProjectName: SimpleSpinner
 * @Package: com.example.myapplication.Utils
 * @Description: java类作用描述
 * @Author: ZHT
 * @CreateDate: 2022/10/29
 */
/**
 * @function:封装下拉选框
 */
public class SimpleSpinner extends androidx.appcompat.widget.AppCompatSpinner {

    private SpinnerAdapter adapter;
    private List<Units> contents;
    private String defaultContent;
    private Context context;
    public SimpleSpinner(Context context) {
        super(context);
        onCreate(context);
    }

    public SimpleSpinner(Context context, int mode) {
        super(context, mode);
        onCreate(context);
    }

    public SimpleSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        onCreate(context);
    }

    public SimpleSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onCreate(context);
    }
    /**
     * @description 初始化
     */
    private void onCreate(Context context){
        this.context = context;
    }
    /**
     * @description 设置spinner数据
     */
    public void setContent(ArrayList<Units> contents){
        this.contents = contents;
        if(adapter!=null){
            adapter = null;
        }
        adapter = new SpinnerAdapter(getContext(),contents);
//        adapter.setDropDownViewResource(R.layout.sp_item_dropdown);
        this.setAdapter(adapter);
    }
    /**
     * @description 设置默认显示内容
     */
    public void setDefaultContent(String defaultContent){
        this.defaultContent = defaultContent;
    }
    /**
     * @description 选择事件
     */
    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener){
        setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //首次刚加载时 判断是否设置默认显示内容，如果有则显示默认内容,逻辑是把第一条的view内容修改掉
                if(!TextUtils.isEmpty(defaultContent)){
                    if(view instanceof TextView){
                        TextView textView = (TextView) view;
                        textView.setText(defaultContent);
                        textView.setTextColor(Color.parseColor("#999999"));
                        defaultContent = "";
                    }
                }else{
                    //把刚刚修改的内容和颜色都修改回来
                    if(position == 0){
                        if(view instanceof TextView){
                            TextView textView = (TextView) view;
                            textView.setText((CharSequence) contents.get(0));
                            textView.setTextColor(Color.parseColor("#ffffff"));
                        }
                    }
                    onItemSelectedListener.onItemSelected(parent,view,position,id, String.valueOf(contents.get(position)));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public interface OnItemSelectedListener{
        void onItemSelected(AdapterView<?> adapterView, View view, int position, long id,String content);
    }
    /**
     * @description 解决 选择相同选项时 点击不触发问题，逻辑是 如果点击的是相同选项则 强制调用一次条码选择事件
     */
    @Override
    public void setSelection(int position) {
        super.setSelection(position);
        boolean sameSelected = position == getSelectedItemPosition();
        if (sameSelected) {
            getOnItemSelectedListener().onItemSelected(this, getSelectedView(),
                    position, getSelectedItemId());
        }
    }
}
