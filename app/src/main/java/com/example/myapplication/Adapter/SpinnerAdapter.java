package com.example.myapplication.Adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.Entity.AddPTypeInfo.PriceType;
import com.example.myapplication.Entity.AddPTypeInfo.Units;
import com.example.myapplication.R;

import java.util.List;

public class SpinnerAdapter extends BaseAdapter {
    private Context context;
    private List<Units> list;

    public SpinnerAdapter(Context context, List<Units> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        Units units = list.get(position);
        View view = LayoutInflater.from(context).inflate(R.layout.item_spinner,null);
        TextView textView = (TextView) view.findViewById(R.id.tv_Title);
        textView.setText(units.getFullName());
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        Units units = list.get(position);
        View view = LayoutInflater.from(context).inflate(R.layout.item_spinner,null);
        TextView textView = (TextView) view.findViewById(R.id.tv_Title);
        textView.setText(units.getFullName());
        return view;
    }
}
