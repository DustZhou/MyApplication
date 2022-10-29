package com.example.myapplication.Utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;
import android.widget.TextView;

import com.example.myapplication.Adapter.FragBAdapter;
import com.example.myapplication.Adapter.SpinnerAdapter;
import com.example.myapplication.Entity.AddPTypeInfo.Units;
import com.example.myapplication.Fragment.Goods.Child.ChildPager.FragmentB;
import com.example.myapplication.ViewModel.AddGoodsModel;

import java.util.ArrayList;
import java.util.List;

import me.yokeyword.fragmentation.SupportFragment;
/**
 *
 * @ProjectName: DiySpinner
 * @Package: com.example.myapplication.Utils
 * @Description: java类作用描述
 * @Author: ZHT
 * @CreateDate: 2022/10/29
 */

public class DiySpinner {
    public SupportFragment fragment;
    private AddGoodsModel model;
    private List<Units> list;
    private String key;
    public TextView TextTv;
    public Context context;
    @SuppressLint("NotConstructor")
    public void DiySpinner(String key, SupportFragment fragment,TextView TextTv, Context context,AddGoodsModel model){
        this.context = context;
        this.fragment = fragment;
        this.key = key;
        this.TextTv = TextTv;
        this.model= model;
        ListPopupWindow popupWindow = new ListPopupWindow(context);
        popupWindow.setAdapter(new SpinnerAdapter(context,model.SpinnerList));
        popupWindow.setAnchorView(TextTv);
        popupWindow.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setModal(true);
        popupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextTv.setText(model.SpinnerList.get(position).getFullName());
                model.UnitsMap.put(key,model.SpinnerList.get(position));
                fragment.findFragment(FragmentB.class).iniUntil();
                popupWindow.dismiss();
            }
        });
        TextTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.show();
            }
        });
    }


    @SuppressLint("NotConstructor")
    public void DiySpinner1(List<Units> list,SupportFragment fragment, TextView TextTv, Context context,AddGoodsModel model){
        this.context = context;
        this.fragment = fragment;
        this.list = list;
        this.TextTv = TextTv;
        this.model= model;
        ListPopupWindow popupWindow = new ListPopupWindow(context);
        popupWindow.setAdapter(new SpinnerAdapter(context,list));
        popupWindow.setAnchorView(TextTv);
        popupWindow.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setModal(true);
        popupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextTv.setText(list.get(position).getFullName());
                model.str = model.stringList.get(position);
                fragment.findFragment(FragmentB.class).WeiZhi();
                popupWindow.dismiss();
            }
        });
        TextTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.show();
            }
        });
    }
}
